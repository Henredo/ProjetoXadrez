# ProjetoXadrez
 <h2>Projeto de Programação orientada a objetos</h2>

<h2>Feito pelo aluno</h2>
  <div style="display: flex;flex-direction: row;">
  <a href="https://github.com/Henredo" target="_blank">
    <img src="https://avatars.githubusercontent.com/u/202291299?v=4" height="64" width="64"/>
    <strong>Henry Monteiro Leme </strong>
  </a>
  </div>

<h2>Capaz de </h2>
- exibir jogo no terminal
- criar partidas
- validar movimentos
- exibir movimentos possiveis
- detectar xeque e xeque mate
- promoção, castle e en passant

<h2> Arquitetura </h2>

    src{
        application{
            Program.java
            UI.java
        }
        boardgame{
            Board
            BoardException
            Piece
            Position
            }
        chess{
            pieces{
                peças
                }
            ChessException.java
            ChessPiece.java
            ChessPosition.java
            Color.java
        }

    

