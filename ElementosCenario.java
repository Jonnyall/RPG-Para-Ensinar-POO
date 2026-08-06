public abstract class ElementosCenario extends TodasAsCoisas implements Interagivel
    {
    // Esta classe representa os elementos de cenário do jogo, que podem ser árvores, pedras, rios, etc.
	// Esta classe implementa a interface Interagivel, ou seja, o jogador poderá interagir com instâncias filhas desta classe.

    // Atributos dos elementos de cenário.
    
    // O nome do elemento de cenário.
    private String nome;

    // A descrição do elemento de cenário.
    private String descricao;

    // Construtor da classe.
    public ElementosCenario(String nome, String descricao)
        {
        this.nome = nome;
        this.descricao = descricao;
        }
    }