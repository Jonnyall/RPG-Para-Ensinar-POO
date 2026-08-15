class NPC extends Personagem implements Interagivel
    {
    // Esta classe representa os NPCs do jogo, ou personagem que passaram missãoes para o jogador (Quests).
    
    // Os atributos do NPC.

    // A missão que o NPC pode passar para o jogador. Um array, uma vez que uma NPC pode possuir mais de uma missão ao mesmo tempo.
    private Missao[] misssoes;

    // Construtor da classe.
    public NPC(String nome, Missao[] misssoes)
        {
        // Atribuindo o nome do NPC.
        super(nome);

        // Atribuindo as missões do NPC.
        this.misssoes = misssoes;
        }
		
	// Métodos de classe.
	
	// Método para verificar se uma determinada missão está completa e passar os itens para o inventário do player.
    /*LOGICA*/

    // Método sobreescritor da interface Interagivel, que permite ao jogador interagir com o NPC.
    @Override
    public void interagir(Heroi heroi)
        {
        // Lógica para interagir com o NPC, como iniciar uma conversa ou aceitar uma missão.
        System.out.println("Você está interagindo com o NPC: " + this.obterNome());
        
        /*LOGICA de mostra as quests disponíveis*/
        }
    }