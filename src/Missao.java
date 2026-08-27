package src;

import java.util.HashMap;
import java.util.Map;

public enum Missao
    {
    // Criando as missões do jogo.

    // Missão: coletar 10 ovos.
    COLETAR_OVOS(
        "Coletar Ovos",
        "Coletar 10 ovos para o taberneiro.",
        new HashMap<Item, Integer>() {{ put(Item.OVO, 10); }},
        new Item[] {},
        new Missao[] {}
    ),

    // Missão: coletar 15 cenouras.
    COLETAR_CENOURAS(
        "Coletar Cenouras",
        "Coletar 15 cenouras para o taberneiro.",
        new HashMap<Item, Integer>() {{ put(Item.CENOURA, 5); }},
        new Item[] {},
        new Missao[] {}
    ),


    // Missão: ajudar o taberneiro com a sua receita secreta de gelatina
    GELATINA_SECRETA(
        "Receita secreta do taberneiro.",
        "Agora que você tem acesso ao depósito da taverna, mate 5 slimes que o taberneiro guarda e traga seus corpos gelatinosos. Com descrição, por favor! Ninguém pode saber como é feita a gelatina do estabelecimento.",
        new HashMap<Item, Integer>() {{ put(Item.CENOURA, 15); }},
        new Item[] {},
        new Missao[] {Missao.COLETAR_OVOS, Missao.COLETAR_CENOURAS}
    );


    // Nome da missão.
    private final String nome;

    // Descrição da missão.
    private final String descricao;

    // Requisitos da missão.
    private final Map<Item, Integer> requisitos;

	// Recompensa da missão.
    private final Item[] recompensas;

    // Missões que são pré-requisitos, ou seja, missões que são necessárias serem cumpridas antes de poder aceitar essa.
    private final Missao[] pre_missaos;

    // Construtor da missão.
    private Missao(String nome, String descricao, Map<Item, Integer> requisitos, Item[] recompensas, Missao[] pre_missaos)
        {
        this.nome = nome;
        this.descricao = descricao;
        this.requisitos = requisitos;
        this.recompensas = recompensas;
        this.pre_missaos = pre_missaos;
        }


    // Métodos de obtenção (getters).
    public String obterNome()
        {
        return (nome);
        }

    public String obterDescricao()
        {
        return (descricao);
        }

    public Map<Item, Integer> obterRequisitos()
        {
        return (requisitos);
        }

    public Item[] obterRecompensas()
        {
        return (recompensas);
        }

    public Missao[] obterPreMissaos()
        {
        return (pre_missaos);
        }

    // Método para verificar se a missão tem premissões.
    public boolean possuiPreMissoes()
        {
        return( pre_missaos != null || pre_missaos.length > 0);
        }

    // Método para verificar se o herói tem todos os requisitos de uma missão.
    public boolean possuiRecursosSuficientes(Heroi heroi)
        {
        for (Map.Entry<Item, Integer> req : this.requisitos.entrySet() ) 
            {
            Item item = req.getKey();
            Integer quantidade = req.getValue();

            // Basta apenas uma ocorrência para se saber que a missão ainda não pode ser completada.
            if (heroi.possuiItemNoInventarioQuantidade(item) < quantidade)
                {
                return (false);
                }
            }
        
        // Se o algoritmo "correu" até este ponto, então pode-se afirmar que o Herói possui todos os requisitos.
        return (true);
        }
    
    // Método para avaliar o estado de disponibilidade da missão.
    public String avaliarDisponibilidade(Heroi heroi)
        { 
        //O Herói já cumpriu a missão?
        if (heroi.verificarMissaoCompletada(this))
            {
            return("Completa");
            }
        // O Heroi está com ela em andamento?
        else if (heroi.obterMissaoAtual() == this)
            {
            // Duas possíbilidades.

            // Não possue todos os requisitos?
            if (! heroi.possuiRequisitosMissao(this))
                {
                return("Em progresso");
                }
            else
                {
                return("Pronta para completar");
                }
            }
        // O Herói não fez as missões necessárias antes desta?
        else if (! heroi.eAceitavelMissao(this))
            {
            return("Indisponível");
            }
        // Se nenhuma dessas perguntas for verdadeira, então a missão está disponível.
        else
            {
            return("Disponível");
            }
        }
    
    // Método para obter a informação por que o herói não pode aceitar uma determinada missão.
    public String avaliarIndisponibilidadeObterInfo(Heroi heroi)
        {
        String _disponibilidade = avaliarDisponibilidade( heroi);
        
        // Primeiro verificando se a missão está indisponível e se a missão tem prequesitos.
        if ( !_disponibilidade.equals("Disponível") )
            {
            // Obtendo as missões que são pre requisitos.
            
            String resposta = "O herói não pode aceitar essa missão. Pois ele precisa completar antes, ele precisa completar as missões: ";

            for(int i = 0; i < this.pre_missaos.length -1; i++)
                {
                resposta += this.pre_missaos[i].obterNome() +", ";
                }
            resposta += this.pre_missaos[this.pre_missaos.length -1].obterNome() +".";

            //retortnando a informação.
            return( resposta );
            }
        else
            {
            return ("A Missão não é um caso de \"Missão Indiponível\".");
            }
        }

    // Método para obter a quantidade necessária de um item específico.
    public int obterQuantidadeNecessaria(Item item)
        {
        return (this.requisitos.getOrDefault(item, 0));
        }

    // Métodos para iterar pelos recursos.

    // Retorna o número total de tipos de requisitos (quantos itens diferentes são necessários).
    public int obterNumeroTipoRequisitos()
        {
        return (requisitos.size() );
        }

    // Dado um índice, retorna o Item correspondente.
    public Item obterTipoRequisitoItem(int indice)
        {
        if (indice < 0 || indice >= requisitos.size())
            {
            throw new IndexOutOfBoundsException("Índice inválido para requisitos da missão.");
            }
        
        return ( (Item) requisitos.keySet().toArray()[indice] );
        }

    // Dado um índice, retorna a quantidade correspondente ao Item.
    public int obterTipoRequisitoQuantidade(int indice)
        {
        if (indice < 0 || indice >= requisitos.size())
            {
            throw new IndexOutOfBoundsException("Índice inválido para requisitos da missão.");
            }
        Item item = (Item) requisitos.keySet().toArray()[indice];
        return (requisitos.get(item));
        }


    // Método que desenha a missão.
    public void desenhar()
        {
        System.out.println("***DETALHES DA MISSÃO***");
        System.out.println("Nome: " +this.nome);
        System.out.println("Descrição: " +this.descricao);

        System.out.println("Requisitos para cumprir a missão:");
        for (Map.Entry<Item, Integer> req : this.requisitos.entrySet() ) 
            {
            Item item = req.getKey();
            Integer quantidade = req.getValue();

            System.out.println("\t" +item.obterNome() +" x " +quantidade);
            }
        }
    }