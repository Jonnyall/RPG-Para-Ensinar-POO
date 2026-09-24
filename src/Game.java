package src;

import java.util.Scanner;

import src.ElementosDeCenario.*;
import src.Inimigos.Inimigo;

public class Game
    {
    // Esta classe irá conter o método main.

    // Responsável pela leitura do teclado do jogo.
    static Scanner GM_Scanner = new Scanner(System.in);

    //Enum para administrar os estados do game.
    public enum GM_Estados
        {
        LOCALIDADE, // Quando a logica do jogo está contina na navegação entre salas.
        CONVERSANDO,// Quando a logica do jogo estiver contina na interação com um NPC (dialogando).
        BATALHA, // Quando o jogador estiver batalhando com inimigos.
        FIM_DE_JOGO; // Quando o jogo terminou.
        }
    //A variável estado do game em si.
    static GM_Estados GM_estado = GM_Estados.LOCALIDADE;

    // Guardará referência para o objeto Herói (o player).
    static Heroi GM_Heroi;

    // A NPC com a qual o herói está interagindo agora.
    static NPC GM_NPC_Agora;

    // Alguns métodos apenas para interagir pela lógica do jogo. (Entre as maquinas de estados)
    
    // Pelas localidades.
    static void interarLocalidade()
        {
        int i;
        
        // Printando a informação da sala para o jogador.
        
        // Obtendo a localidade atual do herói.
        Localidade _localidade_atual = GM_Heroi.obterLocalidade();

        // O nome dá localidade.
        System.out.println("Você está em: " +_localidade_atual.obterNome());

        // Descrevendo a sala.
        System.out.println("\n" +_localidade_atual.obterDescricao() +"\n");

        // Verificando se há inimigos na localidade.
        if (_localidade_atual.possuiInimigos())
            {
            // Printando a informação de que há inimigos na localidade.
            System.out.println("Cuidado! Há inimigos nesta localidade: ");

            // Mudando o estado do jogo para BATALHA.
            GM_estado = GM_Estados.BATALHA;
            }
        else
            {

            // Obtendo as NPCS e elementos do cenário.
            NPC[] _npc_na_localidade            = _localidade_atual.obterNPC();
            int _npc_na_localidade_N = _npc_na_localidade.length;
            ElementosCenario[] _elc_na_localidade = _localidade_atual.obterElementosCenario();
            int _elc_na_localidade_N = _elc_na_localidade.length;

            // Printando as opções de interação para o jogador.

            // Pulando uma linha.
            System.out.println("\n");

            // Apenas mostrando essa informação se existirem NPCs na sala.
            if (_npc_na_localidade_N > 0)
                {
                // As NPCs
                System.out.println("O Herói pode falar com: (Falar)");

                for(i = 0; i < _npc_na_localidade_N; i++)
                    {
                    System.out.println("\t" +i + " - " +_npc_na_localidade[i].obterNome());
                    }        
                
                System.out.println("\n");
                }


            // Apenas mostrando essa informação se existirem objetos interativos na sala.
            if (_elc_na_localidade_N > 0)
                {
                // Os elementos de cenário.
                System.out.println("Também há alguns objetos para o herói interagir: (Interagir)");

                for(i = 0; i < _elc_na_localidade_N; i++)
                    {
                    System.out.println("\t" +i + " - " +_elc_na_localidade[i].obterNome() +"\n" +"\t\t" +_elc_na_localidade[i].obterDescricao());
                    }
                
                System.out.println("\n");
                }


            // Printando as saídas da localidade para o herói.
            Localidade[] _saidas = _localidade_atual.obterCaminhos();
            int _saidas_N = _saidas.length;

            // O Heroi pode proseguir por: (Caminhar)
            System.out.println("O Héroi pode proseguir por: (Caminhar)");

            for(i = 0; i < _saidas_N; i++)
                {
                System.out.println("\t" +i +" - " +_saidas[i].obterNome() +"\n" +"\t\t" +_saidas[i].obterDescricao());
                }

            //Lógica de leitura do teclado aqui.
            String _entrada_do_heroi = GM_Scanner.nextLine();
            String[] _entrada_do_heroi_argv = _entrada_do_heroi.split(" ");

            //Primeiro argumento.
            String _primeiro_argumento = _entrada_do_heroi_argv[0];

            //Avaliando a entrada.
            //Case "Falar":
            if (_primeiro_argumento.equalsIgnoreCase("Falar"))
                {
                // Se não houver NPCs na sala.
                if (_npc_na_localidade_N == 0)
                    {
                    System.out.println("Não há NPCs na sala para o herói conversar...");
                    }
                else
                    {
                    // Antes, é preciso verificar se o segundo argumento foi dado.
                    if (_entrada_do_heroi_argv.length >= 2)
                        {
                        try
                            {
                            int indiceNPC = Integer.parseInt(_entrada_do_heroi_argv[1]);

                            // Verifica se é inteiro >= 0 e dentro do range de NPCs.
                            if (indiceNPC >= 0 && indiceNPC < _npc_na_localidade_N)
                                {
                                // Interação com o NPC escolhido.
                                System.out.println("O Héroi irá falar com " + _npc_na_localidade[indiceNPC].obterNome());
                                GM_NPC_Agora = _npc_na_localidade[indiceNPC];

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
            else if (_primeiro_argumento.equalsIgnoreCase("Interagir"))
                {
                // Se não houver elementos de cenário na sala.
                if (_elc_na_localidade_N == 0)
                    {
                    System.out.println("Não há objetos interativos na sala...");
                    }
                else
                    {
                    // Antes, é preciso verificar se o segundo argumento foi dado.
                    if (_entrada_do_heroi_argv.length >= 2)
                        {
                        try
                            {
                            int indiceObj = Integer.parseInt(_entrada_do_heroi_argv[1]);

                            // Verifica se é inteiro >= 0 e dentro do range de objetos.
                            if (indiceObj >= 0 && indiceObj < _elc_na_localidade_N)
                                {
                                // Interação com o objeto escolhido.
                                System.out.println("O Héroi irá interagir com " + _elc_na_localidade[indiceObj].obterNome());
                                _elc_na_localidade[indiceObj].interagir(GM_Heroi);
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
            else if (_primeiro_argumento.equalsIgnoreCase("Caminhar"))
                {
                // Antes, é preciso verificar se o segundo argumento foi dado.
                if (_entrada_do_heroi_argv.length >= 2)
                    {
                    try
                        {
                        int indiceSaida = Integer.parseInt(_entrada_do_heroi_argv[1]);

                        // Verifica se é inteiro >= 0 e dentro do range de saídas.
                        if (indiceSaida >= 0 && indiceSaida < _saidas_N)
                            {
                            // Caminhar para a saída escolhida.
                            System.out.println("O Héroi irá  para " + _saidas[indiceSaida].obterNome());
                            GM_Heroi.mudarLocalidade(_saidas[indiceSaida]);
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
            else if (_primeiro_argumento.equalsIgnoreCase("Inventario"))
                {
                GM_Heroi.desenharInventario();
                }
            //Case "Missoes"
            else if (_primeiro_argumento.equalsIgnoreCase("Missoes"))
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
        
        // Lógica de leitura do teclado aqui.
        String _entrada_do_heroi = GM_Scanner.nextLine();
        String[] _entrada_do_heroi_argv = _entrada_do_heroi.split(" ");

         //Primeiro argumento.
        String _primeiro_argumento = _entrada_do_heroi_argv[0];

        //Avaliando a entrada.
        //Case "Missao":
        if (_primeiro_argumento.equalsIgnoreCase("Missao"))
            {
            // Primeiro, pergunta-se se a NPC possui missões.
            if (!GM_NPC_Agora.possueMissoes())
                {
                System.out.println(GM_NPC_Agora.obterNome() + " não possui missões...");
                }
            else
                {
                // Antes, é preciso verificar se o segundo argumento foi dado.
                if (_entrada_do_heroi_argv.length >= 2)
                    {
                    try
                        {
                        int indiceNPC = Integer.parseInt(_entrada_do_heroi_argv[1]);

                        Missao missao_olhada = GM_NPC_Agora.obterMissao(indiceNPC);

                        // Avaliando a missão.
                        String missao_olhada_estado = missao_olhada.avaliarDisponibilidade(GM_Heroi);

                        // Se o Herói já possui uma missão em curso e está tentando pegar outra.
                        if (GM_Heroi.obterMissaoAtual() != null && GM_Heroi.obterMissaoAtual() != missao_olhada)
                            {
                            System.out.println("O herói não pode pegar outra missão enquanto estiver em andamento com outra.");
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
                            boolean  _tentando_nova_missao = (GM_Heroi.obterMissaoAtual() == null);

                            // Também deve ser avaliado se o herói já possui todos os itens que a missão exige.
                            boolean _possue_todos_requisitos = (GM_Heroi.possuiRequisitosMissao(missao_olhada));

                            // Apenas uma variavel para ficar "preso no loop"
                            boolean _resposta_valida = false;

                            while (!_resposta_valida)
                                {
                                // Printando a missão até o usuário fazer uma escolha possível.
                                missao_olhada.desenhar();

                                // Se o Herói está tentando aceitar uma nova missão, então só se pode existir duas opções: "Aceitar" ou "Voltar".
                                if (_tentando_nova_missao)
                                    {
                                    System.out.println("\nAceitar/Voltar?\n");
                                    }
                                else
                                    {
                                    // Se o Herói não possui todos os requisitos, as opções possíveis são "Cancelar" ou "Voltar".
                                    if (! _possue_todos_requisitos)
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
                                    //Apenas Voltando para o estado anterior. (falando com a NPC).
                                    
                                    _resposta_valida = true;
                                    }
                                else if (_entrada.equalsIgnoreCase("Aceitar") && _tentando_nova_missao)
                                    {
                                    // Aceitando a missao.
                                    GM_Heroi.aceitaMissao(missao_olhada);

                                    _resposta_valida = true;
                                    }
                                else if (_entrada.equalsIgnoreCase("Cancelar") && !_tentando_nova_missao && !_possue_todos_requisitos)
                                    {
                                    // Cancelando a missão atual.
                                    GM_Heroi.cancelaMissaoAtual();

                                    _resposta_valida = true;
                                    }
                                else if (_entrada.equalsIgnoreCase("Completar") && !_tentando_nova_missao && _possue_todos_requisitos)
                                    {
                                    // Completando a missão atual.
                                    GM_Heroi.completarMissao(missao_olhada);

                                    _resposta_valida = true;
                                    }
                                else
                                    {
                                    //Opisão invalida.
                                    System.out.println("Opção inválida!");

                                    _resposta_valida = false;
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
        else if (_primeiro_argumento.equalsIgnoreCase("Voltar"))
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
        Inimigo[] _inimigos_da_batalha = GM_Heroi.obterLocalidade().obterInimigos();

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
        if (index < 0 && index <= _inimigos_da_batalha.length)
            {
            System.out.println("É necessario dar um numero entre as os inimigos possiveis");
            return(false);
            }

        // Terceira avaliação, se o inimigo escolhido está vivo.
        if (_inimigos_da_batalha[index].obterVida() <= 0)
            {
            System.out.println("O inimigo escolhido já está morto.");
            return(false);
            }
            
        // Se passou por todas as avaliações, então a entrada é válida.
        return(true);
        }
    static void interarBatalha()
        {
        // Aqui será implementada a lógica de batalha.
        
        // Obtendo os inimigos da batalha.
        Inimigo[] _inimigos_da_batalha = GM_Heroi.obterLocalidade().obterInimigos();

        // Printando informações da batalhas.
        System.out.println("O herói está batalhando com os seguintes inimigos: ");
        for (int i = 0; i < _inimigos_da_batalha.length; i++)
            {
            Inimigo inim = _inimigos_da_batalha[i];    
            System.out.println("\t" +i + " - " +inim.obterNome() +" Vida: " +inim.obterVida() +"/" +inim.obterVidaMaxima());
            }

        // Obtendo os itens do herói.
        int N_flechas = GM_Heroi.possuiItemNoInventarioQuantidade(Item.FLECHA);
        int N_bombas = GM_Heroi.possuiItemNoInventarioQuantidade(Item.BOMBA);
        int N_pocao = GM_Heroi.possuiItemNoInventarioQuantidade(Item.POCAO_DE_CURA);

        // Printando informações do herói.
        System.out.println("\nHerói: " +GM_Heroi.obterNome() +" Vida: " +GM_Heroi.obterVida() +"/" +GM_Heroi.obterVidaMaxima());
        System.out.println("\tItens do herói: Flechas: " +N_flechas +", Bombas: " +N_bombas +", Poções de Cura: " +N_pocao);
        

        // Printando as opções de ação do herói.
        System.out.println("O herói pode atacar um inimigo: (Atacar <numero_do_inimigo>)");

        // Printando a opçao de usar uma flecha.
        if (N_flechas > 0)
            {
            System.out.println("O herói pode usar uma flecha: (Flecha <numero_do_inimigo>)");
            }

        // Printando a opçao de usar uma bomba.
        if (N_bombas > 0)
            {
            System.out.println("O herói pode usar uma bomba: (Bomba)");
            }
        
        // Printando a opçao de usar uma poção decura.
        if (N_pocao > 0)
            {
            System.out.println("O herói pode usar uma poção decura: (Pocao)");
            }

        // Apenas uma flag para saber se o herói já usou o seu turno.
        boolean heroi_ja_usou_turno = false;

        // Lendo a entrada do herói.
        String _entrada_do_heroi = GM_Scanner.nextLine();
        String[] _entrada_do_heroi_argv = _entrada_do_heroi.split(" ");

        // Case "Atacar":
        if (_entrada_do_heroi_argv[0].equalsIgnoreCase("Atacar"))
            {
            // Aqui será implementada a lógica de ataque do herói.

            // Antes, é preciso verificar se o segundo argumento foi dado.
            if (_entrada_do_heroi_argv.length >= 2)
                {
                // Avaliando se a entrada do herói é válida.
                if (avaliarEntradaDeAtaque(_entrada_do_heroi_argv[1]))
                    {
                    // Obtendo o índice do inimigo a ser atacado.
                    int indice_inimigo = Integer.parseInt(_entrada_do_heroi_argv[1]);

                    // Obtendo o inimigo a ser atacado.
                    Inimigo inimigo_a_ser_atacado = _inimigos_da_batalha[indice_inimigo];

                    // O herói ataca o inimigo escolhido.
                    GM_Heroi.darEspadada(inimigo_a_ser_atacado);

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
        // Case "Flecha":
        else if (_entrada_do_heroi_argv[0].equalsIgnoreCase("Flecha"))
            {
            // Aqui será implementada a lógica de ataque do herói com flecha.

            // Antes, é preciso verificar se o segundo argumento foi dado.
            if (_entrada_do_heroi_argv.length >= 2)
                {
                // Avaliando se a entrada do herói é válida.
                if (avaliarEntradaDeAtaque(_entrada_do_heroi_argv[1]))
                    {
                    // Obtendo o índice do inimigo a ser atacado.
                    int indice_inimigo = Integer.parseInt(_entrada_do_heroi_argv[1]);

                    // Obtendo o inimigo a ser atacado.
                    Inimigo inimigo_a_ser_atacado = _inimigos_da_batalha[indice_inimigo];

                    // O herói ataca o inimigo escolhido com flecha.
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
        else if (_entrada_do_heroi_argv[0].equalsIgnoreCase("Bomba"))
            {
            // Aqui será implementada a lógica de ataque do herói com bomba.

            // O herói ataca todos os inimigos com bomba.
            GM_Heroi.lancarBomba(_inimigos_da_batalha);

            // Se algum inimigo atacado morreu, então ele deve dropar os itens dele.
            for (int i = 0; i < _inimigos_da_batalha.length; i++)
                {
                Inimigo inimigo_a_ser_atacado = _inimigos_da_batalha[i];

                if (inimigo_a_ser_atacado.obterVida() <= 0)
                    {
                    System.out.println("O inimigo " +inimigo_a_ser_atacado.obterNome() +" foi derrotado!");
                    
                    // O inimigo atacado morreu, então ele deve dropar os itens dele.
                    inimigo_a_ser_atacado.soltarItens(GM_Heroi);
                    }
                }

            // O heroi já fez o seu movimento.
            heroi_ja_usou_turno = true;
            }
        // Case "Pocao":
        else if (_entrada_do_heroi_argv[0].equalsIgnoreCase("Pocao"))
            {
            // Aqui será implementada a lógica de cura do herói com poção.
            GM_Heroi.beberPocaoDeCura();

            // O heroi já fez o seu movimento.
            heroi_ja_usou_turno = true;
            }
        else
            {
            System.out.println("Comando inválido, tente novamente.");
            }
        
        // Se o herói já usou o seu turno, então os inimigos podem fazer os movimentos deles.
        if (heroi_ja_usou_turno)
            {
            // Aqui será implementada a lógica de ataque dos inimigos.
            for (int i = 0; i < _inimigos_da_batalha.length; i++)
                {
                Inimigo inimigo = _inimigos_da_batalha[i];

                // Apenas atacando se o inimigo estiver vivo.
                if (inimigo.obterVida() > 0)
                    {
                    inimigo.atacarHeroi(GM_Heroi);
                    
                    // Esperando um tempo.

                    }
                }
            }

        // Se todos os inimigos estiverem mortos, então a batalha termina.
        if (GM_Heroi.obterLocalidade().todosInimigosDerrotados())
            {
            System.out.println("Todos os inimigos foram derrotados!");

            GM_estado = GM_Estados.LOCALIDADE;
            }
        }

    // Método main da classe.
    public static void main(String[] args)
        {
		
        //Inicializando o "mundo" do RPG.
        Mundo.inicializar();

        // Criando o heroi.
        
        /*
        Ficha do heroi: Nome, Vida, Ataque, Defesa, Sorte.
            Nome: Herói
            Vida: 100
            Ataque: 20
            Defesa: 10
            Sorte: 5
        */
        GM_Heroi = new Heroi();

        //O Herói começa no quarto.
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
                    
                    //
                    interarLocalidade();

                break;
            
                case CONVERSANDO:

                    interarNPC();

                break;

                case BATALHA:
                    
                    // Aqui seria implementada a lógica de batalha.
                    interarBatalha();

                default:
                    break;
                }
        
            // Apenas pulando algumas linhas. (estética)
            System.out.println("\n\n\n");
            }
        }
    }