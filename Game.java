public class Game
    {
    // Esta classe irá conter o método main.

    // Método main da classe.
    public static void main(String[] args)
        {
        // Variável responsável por controlar o loop do jogo.
        boolean jogoRodando = true;
        
		// Guarda qual localidade é a atual.
		Localidade localidade_atual;
		
        // Criando o heroi.
        
        /*
        Ficha do heroi: Nome, Vida, Ataque, Defesa, Sorte.
            Nome: Herói
            Vida: 100
            Ataque: 20
            Defesa: 10
            Sorte: 5
        */
        Heroi HEROI_DO_GAME = new Heroi();

        /*
        Aqui será feito a inicialização do mapa, os inimigos, NPCs e itens que são contidos em cada localidade.
        */

        // Loop principal do jogo.
        while (jogoRodando)
            {
            // Aqui será feito a lógica do jogo, como movimentação do heroi, batalhas, interações com NPCs, etc.
            }
        }
    }