package src;

import java.util.function.Predicate;

public class NPC extends Personagem implements Interagivel
    {
    // Esta classe representa os NPCs do jogo, ou personagem que passaram missãoes para o jogador (Quests).
    
    // Os atributos do NPC.

    // A missão que o NPC pode passar para o jogador. Um array, uma vez que uma NPC pode possuir mais de uma missão ao mesmo tempo.
    private Missao[] misssoes;

    // Estrutura responsável pela "árvore de decisão" dinâmica — que significa, em cada instância, possuir uma diferente — do diálogo da NPC.
    private ArvoreDialogo arvore_dialogo;

    // Construtor da classe.
    public NPC(String nome, Missao[] misssoes)
        {
        // Atribuindo o nome do NPC.
        super(nome);

        // Atribuindo as missões do NPC.
        this.misssoes = misssoes;
        
        // Instanciando uma árvore de diálogo para a NPC.
        this.arvore_dialogo = new ArvoreDialogo();
        }
		
	// Métodos de classe.
	
    // Método para obter a missão da npc
    public Missao obterMissao(int numere_da_missao)
        {
        // Primeiro, verificando se o argumento foi válido.

        if (numere_da_missao < 0)
            {
            // Joga um erro.
            numere_da_missao = 0;
            }
        else if (numere_da_missao >= this.misssoes.length)
            {
            // Joga um erro.
            numere_da_missao = this.misssoes.length -1;
            }
        
        //Se o algoritmo não terminou nas duas outras verificações, então o argumento é válido.
        return (this.misssoes[ numere_da_missao]);
        }

    // Método para "perguntar" se a NPC possui missões.
    public boolean possueMissoes()
        {
        return( this.misssoes != null && this.misssoes.length > 0 );
        }


	// Método para verificar se uma determinada missão está completa e passar os itens para o inventário do player.
    /*LOGICA*/


    // Métodos para configurar a árvore de diálogo.
    public void adicionarRegraArvoreDecisao(Predicate<Heroi> condicao, String dialogo)
        {
        this.arvore_dialogo.adicionaRegra(condicao, dialogo);
        }

    public void configuraDialogoPadrao(String dialogo_padrao)
        {
        this.arvore_dialogo.configuraDialogoPadrao(dialogo_padrao);
        }

    // Método sobreescritor da interface Interagivel, que permite ao jogador interagir com o NPC.
    @Override
    public void interagir(Heroi heroi)
        {
        // Lógica para interagir com o NPC, como iniciar uma conversa ou aceitar uma missão.
        System.out.println("Você está interagindo com o NPC:\n" + this.obterNome());
        
        // Printando o que ele diz para o usuário.
        System.out.println("Ele(a) diz:" +this.arvore_dialogo.obterDialogo(heroi) +"\n");
        
        // Mostrando as missões apenas se O NPC em questão possuir missões.
        if ( this.possueMissoes() )
            {
            System.out.println("\t***MISSÔES***\n");
            
            for( int i = 0; i < this.misssoes.length; i++)
                {
                // Verificando o estado de cada missão.
                Missao missao_avaliada = this.misssoes[i];
                String missao_estado = missao_avaliada.avaliarDisponibilidade(heroi);
                
                // Printando as missões com seus respectivos estados.
                System.out.println("\t\t" +missao_avaliada.obterNome() +" - " +missao_estado);
                }
            }
        }
    }