package src;

import java.util.Scanner;

import src.ElementosDeCenario.*;
import src.Inimigos.Inimigo;

public class Game
    {
    // Esta classe irá conter o método main.

    // Responsável pela leitura do teclado do jogo.
    static Scanner GM_Scanner = new Scanner(System.in);

    // Enum para administrar os estados do game.
    public enum GM_Estados
        {
        LOCALIDADE, // Quando a lógica do jogo está contida na navegação entre salas.
        CONVERSANDO,// Quando a lógica do jogo estiver contínua na interação com um NPC (dialogando).
        BATALHA, // Quando o jogador estiver batalhando com inimigos.
        FIM_DE_JOGO; // Quando o jogo terminou.
        }
    
    // A variável estado do game em si.
    static GM_Estados GM_estado = GM_Estados.LOCALIDADE;

    // Guardará referência para a instancia Herói (o player).
    static Heroi GM_Heroi;

    // A NPC com a qual o Herói está interagindo agora.
    static NPC GM_NPC_Agora;

    // Alguns métodos apenas para interagir pela lógica do jogo. (Entre as maquinas de estados)
    
    // Pelas localidades.
    static void interarLocalidade()
        {   
        // Printando a informação da sala para o jogador.
        
        // Obtendo a localidade atual do Herói.
        Localidade localidade_atual = GM_Heroi.obterLocalidade();

        // O nome da localidade.
        System.out.println("Você está em: " +localidade_atual.obterNome());

        // Descrevendo a localidade.
        System.out.println("\n" +localidade_atual.obterDescricao() +"\n");

        // Verificando se há inimigos na localidade.
        if (localidade_atual.possuiInimigos())
            {
            // Printando a informação de que há inimigos na localidade.
            System.out.println("Cuidado! Há inimigos nesta localidade: ");

            // Mudando o estado do jogo para BATALHA.
            GM_estado = GM_Estados.BATALHA;
            }
        else
            {
            // Obtendo as NPCS e elementos do cenário.
            NPC[] npc_na_localidade            = localidade_atual.obterNPC();
            int _npc_na_localidade_N = npc_na_localidade.length;
            ElementosCenario[] elc_na_localidade = localidade_atual.obterElementosCenario();
            int elc_na_localidade_N = elc_na_localidade.length;

            // Printando as opções para o jogador.

            // Pulando uma linha.
            System.out.println("\n");

            // Mostrando as NPCs, caso a localidade possua alguma.
            if (_npc_na_localidade_N > 0)
                {
                System.out.println("O Herói pode falar com: (Falar <n° da NPC>)");

                for(int i = 0; i < _npc_na_localidade_N; i++)
                    {
                    System.out.println("\t" +i + " - " +npc_na_localidade[i].obterNome());
                    }        
                
                System.out.println("\n");
                }


            // Apenas mostrando essa informação se existirem objetos interativos na sala.
            if (elc_na_localidade_N > 0)
                {
                System.out.println("Também há alguns objetos para o herói interagir: (Interagir <n° do objeto>)");

                for(int i = 0; i < elc_na_localidade_N; i++)
                    {
                    System.out.println("\t" +i + " - " +elc_na_localidade[i].obterNome() +"\n" +"\t\t" +elc_na_localidade[i].obterDescricao());
                    }
                
                System.out.println("\n");
                }


            // Printando as saídas da localidade para o herói.
            Localidade[] saidas = localidade_atual.obterCaminhos();
            int _saidas_N = saidas.length;

            System.out.println("O Héroi pode proseguir por: (Caminhar <n° do caminho>)");

            for(int i = 0; i < _saidas_N; i++)
                {
                System.out.println("\t" +i +" - " +saidas[i].obterNome() +"\n" +"\t\t" +saidas[i].obterDescricao());
                }

            // Lógica de leitura do teclado.
            String entrada_do_heroi = GM_Scanner.nextLine();
            String[] entrada_do_heroi_argv = entrada_do_heroi.split(" ");

            // Primeiro argumento.
            String primeiro_argumento = entrada_do_heroi_argv[0];

            // Avaliando a entrada.
            //Case "Falar":
            if (primeiro_argumento.equalsIgnoreCase("Falar"))
                {
                // Se não houver NPCs na sala.
                if (_npc_na_localidade_N == 0)
                    {
                    System.out.println("Não há NPCs na sala para o Herói conversar...");
                    }
                else
                    {
                    // Antes, é preciso verificar se o segundo argumento foi dado.
                    if (entrada_do_heroi_argv.length >= 2)
                        {
                        try
                            {
                            int indiceNPC = Integer.parseInt(entrada_do_heroi_argv[1]);

                            // Verifica se é inteiro >= 0 e dentro do range de NPCs.
                            if (indiceNPC >= 0 && indiceNPC < _npc_na_localidade_N)
                                {
                                // Interação com o NPC escolhido.
                                System.out.println("O Héroi irá falar com " + npc_na_localidade[indiceNPC].obterNome());
                                GM_NPC_Agora = npc_na_localidade[indiceNPC];

                                // Mudando o estado do jogo.
                                GM_estado = GM_Estados.CONVERSANDO;
                                }
                            else
                                {
                                System.out.println("Número inválido. Escolha um NPC listado.");
                                }
                            }
                        catch (NumberFormatException e)
                            {
                            System.out.println("O argumento deve ser um número inteiro válido.");
                            }       
                        }
                    else
                        {
                        System.out.println("Você precisa especificar o número do NPC para falar.");
                        }
                    }
                }
            //Case "Interagir":
            else if (primeiro_argumento.equalsIgnoreCase("Interagir"))
                {
                // Se não houver elementos de cenário na sala.
                if (elc_na_localidade_N == 0)
                    {
                    System.out.println("Não há objetos interativos na sala...");
                    }
                else
                    {
                    // Antes, é preciso verificar se o segundo argumento foi dado.
                    if (entrada_do_heroi_argv.length >= 2)
                        {
                        try
                            {
                            int indiceObj = Integer.parseInt(entrada_do_heroi_argv[1]);

                            // Verifica se é inteiro >= 0 e dentro do range de objetos.
                            if (indiceObj >= 0 && indiceObj < elc_na_localidade_N)
                                {
                                // Interação com o objeto escolhido.
                                System.out.println("O Héroi irá interagir com " + elc_na_localidade[indiceObj].obterNome());
                                elc_na_localidade[indiceObj].interagir(GM_Heroi);
                                }
                            else
                                {
                                System.out.println("Número inválido. Escolha um objeto listado.");
                                }
                        }
                        catch (NumberFormatException e)
                            {
                            System.out.println("O argumento deve ser um número inteiro válido.");
                            }
                        }
                    else
                        {
                        System.out.println("Você precisa especificar o número do objeto para interagir.");
                        }
                    }
                }
            //Case "Caminhar":
            else if (primeiro_argumento.equalsIgnoreCase("Caminhar"))
                {
                // Antes, é preciso verificar se o segundo argumento foi dado.
                if (entrada_do_heroi_argv.length >= 2)
                    {
                    try
                        {
                        int indiceSaida = Integer.parseInt(entrada_do_heroi_argv[1]);

                        // Verifica se é inteiro >= 0 e dentro do range de saídas.
                        if (indiceSaida >= 0 && indiceSaida < _saidas_N)
                            {
                            // Caminhar para a saída escolhida.
                            System.out.println("O Héroi irá  para " + saidas[indiceSaida].obterNome());
                            GM_Heroi.mudarLocalidade(saidas[indiceSaida]);
                            }
                        else
                            {
                            System.out.println("Número inválido. Escolha uma saída listada.");
                            }
                        }
                    catch (NumberFormatException e)
                        {
                        System.out.println("O argumento deve ser um número inteiro válido.");
                        }
                    }
                else
                    {
                    System.out.println("Você precisa especificar o número da saída para caminhar.");
                    }
                }
            //Case "Inventario"
            else if (primeiro_argumento.equalsIgnoreCase("Inventario"))
                {
                GM_Heroi.desenharInventario();
                }
            //Case "Missoes"
            else if (primeiro_argumento.equalsIgnoreCase("Missoes"))
                {
                GM_Heroi.desenharMissoes();
                }
            // Default:
            else
                {
                System.out.println("Comando inválido.");
                }
            }
        }

    // Com as NPCs.
    static void interarNPC()
        {
        // Interagindo com a NPC atual.
        GM_NPC_Agora.interagir(GM_Heroi);
        
        // Obtendo logo se a NPC em questão possui missões (uma vez que as opções mudam de acordo com essa possibilidade).
        boolean npc_tem_missoes = GM_NPC_Agora.possueMissoes();

        // Mostrando para o usuario quais são os possiveis comandos neste momento.
        if (npc_tem_missoes)
            System.out.println("Voltar/Missao <n° da missão>");
        else
            System.out.println("Voltar");

        // Lógica de leitura do teclado aqui.
        String entrada_do_heroi = GM_Scanner.nextLine();
        String[] entrada_do_heroi_argv = entrada_do_heroi.split(" ");

        // Primeiro argumento.
        String primeiro_argumento = entrada_do_heroi_argv[0];

        //Avaliando a entrada.
        //Case "Missao":
        if (primeiro_argumento.equalsIgnoreCase("Missao"))
            {
            // Primeiro, pergunta-se se a NPC não possui missões.
            if (!npc_tem_missoes)
                {
                System.out.println(GM_NPC_Agora.obterNome() + " não possui missões...");
                }
            else
                {
                // Antes, é preciso verificar se o segundo argumento foi dado.
                if (entrada_do_heroi_argv.length >= 2)
                    {
                    try
                        {
                        int indiceNPC = Integer.parseInt(entrada_do_heroi_argv[1]);

                        Missao missao_olhada = GM_NPC_Agora.obterMissao(indiceNPC);

                        // Avaliando a missão.
                        String missao_olhada_estado = missao_olhada.avaliarDisponibilidade(GM_Heroi);

                        // Se o Herói já possui uma missão em curso e está tentando pegar outra.
                        if (GM_Heroi.obterMissaoAtual() != null && GM_Heroi.obterMissaoAtual() != missao_olhada)
                            {
                            System.out.println("O Herói não pode pegar outra missão enquanto estiver em andamento com outra.");
                            }
                        // Se o Herói já completou a missão.
                        else if (GM_Heroi.verificarMissaoCompletada(missao_olhada))
                            {
                            System.out.println("Essa missão já foi concluída!");
                            }
                        // Se a missão está indisponível.
                        else if (missao_olhada_estado.equalsIgnoreCase("Indisponível"))
                            {
                            System.out.println(missao_olhada.avaliarIndisponibilidadeObterInfo(GM_Heroi));
                            }
                        else
                            {
                            // Então resta apenas duas possibilidades.
                            // Ou o herói está tentando pegar uma nova missão, ou o herói está visualizando uma missão que está em curso.
                            boolean  tentando_nova_missao = (GM_Heroi.obterMissaoAtual() == null);

                            // Também deve ser avaliado se o herói já possui todos os itens que a missão exige.
                            boolean possue_todos_requisitos = (GM_Heroi.possuiRequisitosMissao(missao_olhada));

                            // Apenas uma variável para o usuário ficar "preso no loop" até o usuário dar uma resposta válida.
                            boolean resposta_valida = false;

                            while (!resposta_valida)
                                {
                                // Printando a missão até o usuário fazer uma escolha possível.
                                missao_olhada.desenhar();

                                // Se o Herói está tentando aceitar uma nova missão, então só se pode existir duas opções: "Aceitar" ou "Voltar".
                                if (tentando_nova_missao)
                                    {
                                    System.out.println("\nAceitar/Voltar?\n");
                                    }
                                else
                                    {
                                    // Se o Herói não possui todos os requisitos, as opções possíveis são "Cancelar" ou "Voltar".
                                    if (!possue_todos_requisitos)
                                        {
                                        System.out.println("\nCancelar/Voltar?\n");
                                        }
                                    // Se o Herói possui todos os requisitos, as opções possíveis são "Completar", "Cancelar" ou "Voltar".
                                    else 
                                        {
                                        System.out.println("\nCompletar/Cancelar/Voltar?\n");
                                        }
                                    }

                                // Capturando a resposta do usuário à escolha da opção de missões.
                                String _entrada = GM_Scanner.nextLine();

                                if (_entrada.equalsIgnoreCase("Voltar"))
                                    {
                                    // Apenas Voltando para o estado anterior. (falando com a NPC).
                                    resposta_valida = true;
                                    }
                                else if (_entrada.equalsIgnoreCase("Aceitar") && tentando_nova_missao)
                                    {
                                    // Aceitando a missão.
                                    GM_Heroi.aceitaMissao(missao_olhada);

                                    resposta_valida = true;
                                    }
                                else if (_entrada.equalsIgnoreCase("Cancelar") && !tentando_nova_missao && !possue_todos_requisitos)
                                    {
                                    // Cancelando a missão atual.
                                    GM_Heroi.cancelaMissaoAtual();

                                    resposta_valida = true;
                                    }
                                else if (_entrada.equalsIgnoreCase("Completar") && !tentando_nova_missao && possue_todos_requisitos)
                                    {
                                    // Completando a missão atual.
                                    GM_Heroi.completarMissao(missao_olhada);

                                    resposta_valida = true;
                                    }
                                else
                                    {
                                    //Opisão invalida.
                                    System.out.println("Opção inválida!");

                                    resposta_valida = false;
                                    }
                                }
                            }
                        }
                    catch (NumberFormatException e)
                        {
                        System.out.println("Número inválido. Escolha uma Missão listada.");
                        }             
                    }
                else
                    {
                    System.out.println("Você precisa especificar o número da Missão para aceitar uma.");
                    }
                }
            }
        //Case "Voltar":
        else if (primeiro_argumento.equalsIgnoreCase("Voltar"))
            {
            // "Parando" de conversar com o NPC e voltando para o estádo anterior.
            GM_NPC_Agora = null;
            GM_estado = GM_Estados.LOCALIDADE;
            }
        //Default:
        else
            {
            System.out.println("Comando inválido.");
            }
        }
    
    // Com as batalhas.
    static boolean avaliarEntradaDeAtaque(String index_text)
        {
        // Obtendo os inimigos da batalha.
        Inimigo[] inimigos_da_batalha = GM_Heroi.obterLocalidade().obterInimigos();

        // Avaliando se o segundo argumento é um número inteiro válido.
        int index;
        try
            {
            index = Integer.parseInt(index_text);
            }
        catch (NumberFormatException e)
            {
            System.out.println("O argumento deve ser um número inteiro válido.");
            return(false);
            }

        // Avaliando se o número dado é valido na lista de inimigos.
        if (index < 0 && index <= inimigos_da_batalha.length)
            {
            System.out.println("É necessário dar um número entre os inimigos possíveis.");
            return(false);
            }

        // Terceira avaliação, se o inimigo escolhido está vivo.
        if (inimigos_da_batalha[index].obterVida() <= 0)
            {
            System.out.println("O inimigo escolhido já está morto.");
            return(false);
            }
            
        // Se passou por todas as avaliações, então a entrada é válida.
        return(true);
        }
    static void interarBatalha()
        {
        // Obtendo os inimigos da batalha.
        Inimigo[] inimigos_da_batalha = GM_Heroi.obterLocalidade().obterInimigos();

        // Printando informações da batalhas.
        System.out.println("O herói está batalhando com os seguintes inimigos: ");
        for (int i = 0; i < inimigos_da_batalha.length; i++)
            {
            Inimigo inim = inimigos_da_batalha[i];
            
            String inim_text = "\t" +i + " - " +inim.obterNome();
            if (inim.obterVida() >= 0)
                {
                inim_text += " Vida: " +inim.obterVida() +"/" +inim.obterVidaMaxima();
                }
            else
                {
                inim_text += " Vida: " +"XX/" +inim.obterVidaMaxima();
                }
            
            System.out.println(inim_text);
            }

        // Apenas pulando uma linha.
        System.out.println("\n");


        // Obtendo os itens do Herói.
        int N_flechas = GM_Heroi.possuiItemNoInventarioQuantidade(Item.FLECHA);
        int N_bombas = GM_Heroi.possuiItemNoInventarioQuantidade(Item.BOMBA);
        int N_pocao = GM_Heroi.possuiItemNoInventarioQuantidade(Item.POCAO_DE_CURA);

        // Printando informações do Herói.
        System.out.println("\nHerói: " +GM_Heroi.obterNome() +" Vida: " +GM_Heroi.obterVida() +"/" +GM_Heroi.obterVidaMaxima());
        System.out.println("\tItens do herói: Flechas: " +N_flechas +", Bombas: " +N_bombas +", Poções de Cura: " +N_pocao);
        

        // Printando as opções de ação do herói.
        System.out.println("O Herói pode atacar um inimigo: (Atacar <numero_do_inimigo>)");

        // Printando a opção de usar uma flecha.
        if (N_flechas > 0)
            {
            System.out.println("O Herói pode usar uma flecha: (Flecha <numero_do_inimigo>)");
            }

        // Printando a opção de usar uma bomba.
        if (N_bombas > 0)
            {
            System.out.println("O Herói pode usar uma bomba: (Bomba)");
            }
        
        // Printando a opção de usar uma poção de cura.
        if (N_pocao > 0)
            {
            System.out.println("O Herói pode usar uma poção de cura: (Pocao)");
            }

        // Apenas uma flag para o sistema saber se o herói já usou o seu turno.
        boolean heroi_ja_usou_turno = false;

        // Lendo a entrada do herói.
        String entrada_do_heroi = GM_Scanner.nextLine();
        String[] entrada_do_heroi_argv = entrada_do_heroi.split(" ");

        // Case "Atacar":
        if (entrada_do_heroi_argv[0].equalsIgnoreCase("Atacar"))
            {
            // Antes, é preciso verificar se o segundo argumento foi dado.
            if (entrada_do_heroi_argv.length >= 2)
                {
                // Avaliando se a entrada do Herói foi válida.
                if (avaliarEntradaDeAtaque(entrada_do_heroi_argv[1]))
                    {
                    // Obtendo o índice do inimigo a ser atacado.
                    int indice_inimigo = Integer.parseInt(entrada_do_heroi_argv[1]);

                    // Obtendo o inimigo a ser atacado.
                    Inimigo inimigo_a_ser_atacado = inimigos_da_batalha[indice_inimigo];

                    // O Herói ataca o inimigo escolhido.
                    GM_Heroi.darEspadada(inimigo_a_ser_atacado);

                    // Se o inimigo atacado morreu, então ele deve dropar os itens dele.
                    if (inimigo_a_ser_atacado.obterVida() <= 0)
                        {
                        System.out.println("O inimigo " +inimigo_a_ser_atacado.obterNome() +" foi derrotado!");
                        
                        // O inimigo atacado morreu, então ele deve dropar os itens.
                        inimigo_a_ser_atacado.soltarItens(GM_Heroi);
                        }

                    // O heroi já fez o seu movimento.
                    heroi_ja_usou_turno = true;
                    }   
                }
            else
                {
                System.out.println("Você precisa especificar o número do inimigo para atacar.");
                }
            }
        // Case "Flecha":
        else if (entrada_do_heroi_argv[0].equalsIgnoreCase("Flecha"))
            {
            // Antes, é preciso verificar se o segundo argumento foi dado.
            if (entrada_do_heroi_argv.length >= 2)
                {
                // Avaliando se a entrada do herói é válida.
                if (avaliarEntradaDeAtaque(entrada_do_heroi_argv[1]))
                    {
                    // Obtendo o índice do inimigo a ser atacado.
                    int indice_inimigo = Integer.parseInt(entrada_do_heroi_argv[1]);

                    // Obtendo o inimigo a ser atacado.
                    Inimigo inimigo_a_ser_atacado = inimigos_da_batalha[indice_inimigo];

                    // O Herói ataca o inimigo escolhido com flecha.
                    GM_Heroi.darFlechada(inimigo_a_ser_atacado);

                    // Se o inimigo atacado morreu, então ele deve dropar os itens dele.
                    if (inimigo_a_ser_atacado.obterVida() <= 0)
                        {
                        System.out.println("O inimigo " +inimigo_a_ser_atacado.obterNome() +" foi derrotado!");
                        
                        // O inimigo atacado morreu, então ele deve dropar os itens dele.
                        inimigo_a_ser_atacado.soltarItens(GM_Heroi);
                        }

                    // O heroi já fez o seu movimento.
                    heroi_ja_usou_turno = true;
                    }   
                }
            else
                {
                System.out.println("Você precisa especificar o número do inimigo para atacar.");
                }
            }
        // Case "Bomba":
        else if (entrada_do_heroi_argv[0].equalsIgnoreCase("Bomba"))
            {
            // O Herói ataca todos os inimigos com bomba.
            GM_Heroi.lancarBomba(inimigos_da_batalha);

            // Se algum inimigo atacado morreu, então ele deve dropar os itens dele.
            for (int i = 0; i < inimigos_da_batalha.length; i++)
                {
                Inimigo inimigo_a_ser_atacado = inimigos_da_batalha[i];

                if (inimigo_a_ser_atacado.obterVida() <= 0)
                    {
                    System.out.println("O inimigo " +inimigo_a_ser_atacado.obterNome() +" foi derrotado!");
                    
                    // O inimigo atacado morreu, então ele deve dropar os itens dele.
                    inimigo_a_ser_atacado.soltarItens(GM_Heroi);
                    }
                }

            // O Herói já fez o seu movimento.
            heroi_ja_usou_turno = true;
            }
        // Case "Pocao":
        else if (entrada_do_heroi_argv[0].equalsIgnoreCase("Pocao"))
            {
            // Chamando o método do herói responsável pelo uso da poção de cura.
            GM_Heroi.beberPocaoDeCura();

            // O Herói já fez o seu movimento.
            heroi_ja_usou_turno = true;
            }
        else
            {
            System.out.println("Comando inválido, tente novamente.");
            }
        
        // Se o herói já usou o seu turno, então os inimigos podem fazer os movimentos deles.
        if (heroi_ja_usou_turno)
            {
            // Cada inimigo presente irá fazer seu movimento.
            for (int i = 0; i < inimigos_da_batalha.length; i++)
                {
                Inimigo inimigo = inimigos_da_batalha[i];

                // O inimigo só pode fazer seu movimento caso esteja vivo.
                if (inimigo.obterVida() > 0)
                    {
                    inimigo.atacarHeroi(GM_Heroi);
                    
                    // Esperando um tempo.
                    // sleep(2.50 segundos)
                    }
                }
            }

        // Se todos os inimigos estiverem mortos, então a batalha termina.
        if (GM_Heroi.obterLocalidade().todosInimigosDerrotados())
            {
            System.out.println("Todos os inimigos foram derrotados!");

            // Voltando ao estado anterior.
            GM_estado = GM_Estados.LOCALIDADE;
            }
        }

    // Método main da classe.
    public static void main(String[] args)
        {
        //Inicializando o "mundo" do nosso RPG.
        Mundo.inicializar();

        /* Criando o heroi.
        Ficha do heroi: Nome, Vida, Ataque, Defesa, Sorte.
            Nome: Herói
            Vida: 100
            Ataque: 20
            Defesa: 10
            Sorte: 5
        */
        GM_Heroi = new Heroi();

        // O Herói começa no quarto dele.
        GM_Heroi.mudarLocalidade(
            Mundo.GM_Localidades.QUARTO_DO_HEROI.retornar()
        );

        // Cheats. Apenas para agilizar os testes.
        GM_Heroi.adicionarItemAoInventario(Item.OVO, Missao.COLETAR_OVOS.obterQuantidadeNecessaria(Item.OVO));
        GM_Heroi.adicionarItemAoInventario(Item.CENOURA, Missao.COLETAR_CENOURAS.obterQuantidadeNecessaria(Item.CENOURA));
        GM_Heroi.completarMissao(Missao.COLETAR_CENOURAS);
        GM_Heroi.completarMissao(Missao.COLETAR_OVOS);
        GM_Heroi.adicionarItemAoInventario(Item.BOMBA, 5);

        // Loop principal do jogo.
        while (GM_estado != GM_Estados.FIM_DE_JOGO)
            {
            // Aqui será feito a lógica do jogo, como movimentação do heroi, batalhas, interações com NPCs, etc.
            switch (GM_estado)
                {
                case LOCALIDADE:
                    interarLocalidade();
                break;
            
                case CONVERSANDO:
                    interarNPC();
                break;

                case BATALHA:
                    
                    interarBatalha();
                break;

                default:
                break;
                }
        
            // Apenas pulando algumas linhas. (estética)
            System.out.println("\n\n\n");
            }
        }
    }