package src;

import java.util.ArrayList;

import src.Inimigos.Inimigo;


public class Heroi extends PersonagemQueBatalha
    {
    // Esta classe representa o personagem principal do jogo, aquele que o jogador controla.

    // Atributos do personagem (Hero).

	// O inventário que o herói carrega.
	private Inventario inventario_do_heroi;

    // A Missão que o herói está realizando.
    private Missao missao_atual;

    // A lista de missões que o herói já completou.
    private ArrayList<Missao> missoes_completadas = new ArrayList<Missao>(); // Lista é inicializada vazia, pois o herói ainda não completou nenhuma missão.

    // A localidade atual do herói.
    private Localidade localidade_atual;

    // Construtor da classe.
    public Heroi()
        {
        // Ficha do heroi: Nome, Vida, Ataque, Defesa, Sorte.
        /*
            Nome: Herói
            Vida: 100
            Ataque: 20
            Defesa: 10
            Sorte: 5
        */
        super("Heroi", 100, 20, 10, 5);
        
        // Inicializando (ou instanciando) o inventário do Heroi.
        this.inventario_do_heroi = new Inventario();
        }
    
    // Métodos da classe.

    // Métodos para o herói atacar inimigos.
    public void darEspadada(Inimigo inimigo)
        {
        // Aqui será implementado a lógica para o heroi dar uma espada.
        Dano dano_espada = new Dano(this, 1.0, 1.0);
        int danoCausado = inimigo.receberDano(dano_espada);
        
        // Avaliando o resultado do dano causado.
        if (danoCausado != PersonagemQueBatalha.PQB_DANO_DESVIADO)
            {
            // O dano foi causado com sucesso.
            System.out.println("O Heroi atacou o inimigo " +inimigo.obterNome() +" com sua espada e causou " +danoCausado +" de dano.");
            }
        else
            {
            // O dano foi desviado.
            System.out.println("O Heroi atacou o inimigo " +inimigo.obterNome() +" com sua espada, mas ele desviou.");
            }
        }

    public void darFlechada(Inimigo inimigo)
        {
        // Aqui será implementado a lógica para o heroi dar uma flechada.

        // Primeiro vare-se o inventário do herói para verificar se ele possui flechas.
        if (this.inventario_do_heroi.quantidadeItemEspecifico(Item.FLECHA) > 0)
            {
            // Se o herói possui flechas, ele pode dar uma flechada.
            
            // Aqui poderia ser implementada a lógica para causar dano ao inimigo com a flechada.
            Dano dano_flechada = new Dano(this, 2.5, 7.5); // Ataque mais forte e mais preciso.
            int danoCausado = inimigo.receberDano(dano_flechada);

            // Avaliando o resultado do dano causado.
            if (danoCausado != PersonagemQueBatalha.PQB_DANO_DESVIADO)
                {
                // O dano foi causado com sucesso.
                System.out.println("O Heroi atirou uma flecha no inimigo " +inimigo.obterNome() +" e causou " +danoCausado +" de dano.");
                }
            else
                {
                // O dano foi desviado.
                System.out.println("O Heroi atirou uma flecha no inimigo " +inimigo.obterNome() +", mas ele desviou.");
                }

            // Após dar a flechada, o herói deve perder uma flecha do seu inventário.
            this.inventario_do_heroi.removerItem(Item.FLECHA);
            }
        else
            {
            // Se o herói não possui flechas, ele não pode dar uma flechada.
            System.out.println("O heroi não possui flechas para dar uma flechada.");
            }
        }

    public void lancarBomba(Inimigo [] inimigo)
        {
        // Aqui será implementado a lógica para o heroi lançar uma bomba em vários inimigos.

        // Primeiro vare-se o inventário do herói para verificar se ele possui bombas.
        if (this.inventario_do_heroi.quantidadeItemEspecifico(Item.BOMBA) > 0)
            {
            // Se o herói possui bombas, ele pode lançar uma bomba.
            System.out.println("O heroi lançou uma bomba nos inimigos!");

            // Aqui poderia ser implementada a lógica para causar dano a todos os inimigos com a bomba.
            Dano dano_bomba = new Dano(this, 5.0, 100.0); // Ataque mais forte e quase infalível.
            for (Inimigo i : inimigo)
                {
                int danoCausado = i.receberDano(dano_bomba);

                // Avaliando o resultado do dano causado.
                if (danoCausado != PersonagemQueBatalha.PQB_DANO_DESVIADO)
                    {
                    // O dano foi causado com sucesso.
                    System.out.println("A bomba causou " +danoCausado +" de dano no inimigo " +i.obterNome() +".");
                    }
                else
                    {
                    // O dano foi desviado.
                    System.out.println("A bomba não causou dano no inimigo " +i.obterNome() +", pois ele desviou.");
                    }
                }

            // Após lançar a bomba, o herói deve perder uma bomba do seu inventário.
            this.inventario_do_heroi.removerItem(Item.BOMBA);
            }
        else
            {
            // Se o herói não possui bombas, ele não pode lançar uma bomba.
            System.out.println("O Heroi não possui bombas para lançar.");
            }
        }


    // Métodos para o herói se curar.
    public void beberPocaoDeCura()
        {
        // Aqui será implementado a lógica para o heroi se curar.
        // Primeiro vare-se o inventário do herói para verificar se ele possui poções de cura.
        if (this.inventario_do_heroi.quantidadeItemEspecifico(Item.POCAO_DE_CURA) > 0)
            {
            // Se o herói possui poções de cura, ele pode se curar.
            this.curar(20); // Supondo que a poção de cura recupere 20 de vida.
            System.out.println("O heroi bebeu uma poção de cura e recuperou 20 de vida.");

            // Após beber a poção de cura, o herói deve perder uma poção do seu inventário.
            this.inventario_do_heroi.removerItem(Item.POCAO_DE_CURA);
            }
        else
            {
            // Se o herói não possui poções de cura, ele não pode se curar.
            System.out.println("O heroi não possui poções de cura para beber.");
            }
        }


    // Método para lidar com o inventário do herói.

    // Método para adicionar um item ao inventário do herói.
    public void adicionarItemAoInventario(Item item)
        {
        this.inventario_do_heroi.adicionarItem(item);
        }

    // Método para adicionar vários itens ao inventário do herói.
    public void adicionarItemAoInventario(Item item, int quantidade)
        {
        for (int i = 0; i < quantidade; i++)
            {
            adicionarItemAoInventario(item);
            }
        }

    // Método para verificar se o herói possui um item específico no inventário.
    public boolean possuiItemNoInventario(Item item)
        {
        return (this.inventario_do_heroi.quantidadeItemEspecifico(item) > 0);
        }
    
    // Método para obter a quantidade que o herói tem em seu inventário do item.
    public int possuiItemNoInventarioQuantidade(Item item)
        {
        return (this.inventario_do_heroi.quantidadeItemEspecifico(item) );
        }

    // ---- ATENÇÂO OU DÚVIDA: O controle de missões do herói deveria ficar na classe Heroi? Ou na classe NPC? Ou em uma outra classe que gerencie as missões do jogo? 

    // Método para o heroi aceitar a missão
    public void aceitaMissao(Missao missao)
        {
        this.missao_atual = missao;
        }

    // Método para obter qual é a missão atual do herói.
    public Missao obterMissaoAtual()
        {
        return (this.missao_atual);
        }

    // Método para completar uma missão.
    public void completarMissao(Missao missao)
        {
        // Adicionando a missão à lista de missões completadas.
        this.missoes_completadas.add(missao);
        
        // Removendo os itens do inventário do herói que foram usados para completar a missão.
        for (int i = 0; i < missao.obterNumeroTipoRequisitos(); i++)
            {
            Item item = missao.obterTipoRequisitoItem(i);
            int quant = missao.obterTipoRequisitoQuantidade(i);

            // Removendo a quantidade de itens do inventário do herói.
            for (int j = 0; j < quant; j++)
                {
                this.inventario_do_heroi.removerItem(item);
                }
            }

        // Se por acaso for a missão que o herói está cumprindo, for a que ele está no momento, então aproveita para limpar a missão atual.
        if (this.missao_atual == missao)
            {
            this.missao_atual = null;
            }
        }

    // Método para cancelar a missão atual do Herói.
    public void cancelaMissaoAtual()
        {
        this.missao_atual = null;
        }

    // Método para verificar se uma dada missão já foi completada.
    public boolean verificarMissaoCompletada(Missao missao)
        {
        // Verificando se a missão está na lista de missões completadas.
        return (this.missoes_completadas.contains(missao));
        }
    
    // Método para verificar se um grupo de missões (um array) foi cumprido, retornando "true" somente se todas forem completadas.
    public boolean verificarMissoesCompletadas(Missao[] missoes)
        {
        // Para cada missão no argumento, faz-se a checagem.
        for (int i = 0; i < missoes.length; i++)
            {
            //  Basta apenas uma ocorrência de uma missão não cumprida para se retornar "false".
            if (! verificarMissaoCompletada(missoes[i]))
                {
                return(false);
                }
            }

        // Se o algoritmo atingiu este ponto, significa que todas as missões dadas de argumento foram cumpridas. Isso significa que pode-se retornar "true".
        return(true);
        }

    // Método para verificar se uma determinada missão pode ser aceita pelo Herói.
    public boolean eAceitavelMissao(Missao missao)
        {
        return( this.verificarMissoesCompletadas( missao.obterPreMissaos()) );
        }

    // Método para verificar se o herói tem todos os requisitos que uma missão exige.
    public boolean possuiRequisitosMissao(Missao missao)
        {
        // Obtendo os requisitos da missão.
        return( missao.possuiRecursosSuficientes(this) );
        }

    // Método para mudar a localidade atual do herói.
    public void mudarLocalidade(Localidade nova_localidade)
        {
        // Finalizando a localidade atual.
        if (this.localidade_atual != null)
            {
            this.localidade_atual.finalizarLocalidade();
            }

        // Atualizando a localidade atual.
        this.localidade_atual = nova_localidade;

        // Iniciando a nova localidade.
        if (nova_localidade != null)
            {
            this.localidade_atual.iniciarLocalidade();
            }
        }
    
    // Método para obter a localidade atual do herói.
    public Localidade obterLocalidade()
        {
        return (this.localidade_atual);
        }
    
    
    // Método para "desenhar" o inventário do herói.
    public void desenharInventario()
        {
        System.out.println("\n--- INVENTÁRIO DO HERÓI ---\n");
        
        // Perguntando se o herói possui algum item no inventário.
        if (this.inventario_do_heroi.quantidadeItens() == 0)
            {
            System.out.println("\nO herói não possui nenhum item em seu inventário.\n");
            }
        else
            {
            // Mostrando os itens do inventário.
            for (int i = 0; i < this.inventario_do_heroi.quantidadeItens(); i++)
                {
                Item item = this.inventario_do_heroi.obterItem(i);

                System.out.println("\t" +item.obterNome());
                }
            }
        }



    // Método para "desenhar" o log das missões.
    public void desenharMissoes()
        {
        // Primeiramente, mostrando qual a missão está no momento.
        System.out.println("\n--- MISSÃO ATUAL ---\n");

        // Perguntando se o herói está a fazer alguma missão no momento.
        if (this.missao_atual == null)
            {
            System.out.println("\nNENHUMA MISSÃO NO MOMENTO.\n");
            }
        else
            {
            // Mostrando a quest.
            System.out.println("Nome: " +this.missao_atual.obterNome() +"\nDescriçao: " +this.missao_atual.obterDescricao() +"\n");

            // Mostrando o progresso da quest.
            System.out.println("--- PROGRESSO ---\n");

            for(int i = 0; i < this.missao_atual.obterNumeroTipoRequisitos(); i++)
                {
                Item item = this.missao_atual.obterTipoRequisitoItem(i);
                int quant = this.possuiItemNoInventarioQuantidade(item);
                int quant_total = this.missao_atual.obterTipoRequisitoQuantidade(i);

                System.out.println("\t" +item.obterNome() +"\t\t - " +quant +"/" +quant_total);
                }
            }

        // Mostrando as missões já cumpridas.
        System.out.println("\n--- MISSÃO JÁ CUMPRIDAS ---\n");

        // Perguntando se o herói cumpriu pelo menos uma missão.
        if (this.missoes_completadas.isEmpty())
            {
            System.out.println("\nO herói ainda não cumpriu nenhuma missão.\n");
            }
        else
            {
            for (Missao i : this.missoes_completadas)
                {
                System.out.println(i.obterNome());
                }
            }
        }
    }
