public abstract class Personagem extends TodasAscoisas
    {
    // Esta classe é a classe designada para os personagens do jogo, sejam eles jogadores ou NPCs ou até monstros.
    
    // Atributos do personagem.

    // O nome do personagem.
    private String nome;

    // Construtor da classe.
    public Personagem(String nome)
        {
        // Atribuindo o nome do personagem.
        this.nome = nome;
        }
		
	// Método de classe
	
	// Apenas um método para se reaver o nome do personagem.
	public String obterNome()
		{
		return(this.noem);
		}
    }
