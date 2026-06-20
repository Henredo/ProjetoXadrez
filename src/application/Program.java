package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		// Cria a lista fora do loop para manter o histórico das peças comidas
		List<ChessPiece> captured = new ArrayList<>();

		while (!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();
				// Passa a lista 'captured' que criamos ali em cima
				UI.printMatch(chessMatch, captured);
				System.out.println();
				System.out.print("Origem: ");
				ChessPosition source = UI.readChessPosition(sc);

				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				application.UI.clearScreen();
				application.UI.printBoard(chessMatch.getPieces(), possibleMoves);

				System.out.println();
				System.out.print("Destino: ");
				ChessPosition target = UI.readChessPosition(sc);

				// 1. Executa o movimento APENAS UMA VEZ
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				// 2. Se alguma peça foi capturada, adiciona na lista da UI
				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}

				// 3. Lógica de PROMOÇÃO (Fica aqui dentro do Try)
				if (chessMatch.getPromoted() != null) {
					System.out.print("Entre com a peca para promocao (B/N/R/Q): ");
					String type = sc.nextLine().toUpperCase();
					// Loop defensivo para garantir que o usuário digite algo válido
					while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
						System.out.print("Valor invalido! Entre com a peca para promocao (B/N/R/Q): ");
						type = sc.nextLine().toUpperCase();
					}
					chessMatch.replacePromotedPiece(type);
				}
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}
}