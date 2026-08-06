public class Localidade extends TodasAsCoisas
    {
    // Esta classe representa uma localidade do jogo, que pode ser uma cidade, uma floresta, uma caverna, etc. Ela possui atributos como nome, descrição e métodos para interagir com o jogador.

    // Atributos da localidade.
    
    // O nome da localidade.
    private String nome;

    // A descrição da localidade.
    private String descricao;

    // As NPCs (personagens não jogáveis) presentes na localidade.
    private Personagem[] npcs;

    // Os Elementos de cenário presentes na localidade.
    private ElementosCenario[] elementos;

    // Os caminhos possiveis para outras localidades a partir desta localidade.
    private Localidade[] caminhos;

    // Construtor da classe.
    public Localidade(String nome, String descricao)
        {
        this.nome = nome;
        this.descricao = descricao;
        }

    // Métodos da classe.

    // Método para adicionar um caminho para outra localidade.
    public void configurarCaminhos(Localidade[] caminhos)
        {
        this.caminhos = caminhos;

        /*
        OBS.: Como esse atributo precisa de objetos (instâncias) de outras localidades, ele não pode ser configurado no construtor da classe, pois as localidades ainda não foram instanciadas. Por isso, ele é configurado em um método separado.
        */
        }

    // Método para adicionar NPCs à localidade.
    public void configurarNPCs(Personagem[] npcs)
        {
        this.npcs = npcs;
        }

    // Método para adicionar elementos de cenário à localidade.
    public void configurarElementos(ElementosCenario[] elementos)
        {
        this.elementos = elementos;
        }
    }