package src;

import java.util.Scanner;
import src.ElementosDeCenario.*;

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

    // Inicializando as localidades.
    public enum GM_Localidades 
        {
        // Localidade 1: O quarto do herói.
        QUARTO_DO_HEROI(new Localidade(
            "Quarto do Herói", 
            "O quarto do herói é um lugar simples, mas aconchegante. Há uma cama, uma mesa e uma estante com alguns livros."
        )),

        // Localidade 2: A taberna.
        TABERNA(new Localidade(
            "Taberna", 
            "A taberna é um lugar animado onde os habitantes do vilarejo se reúnem para beber e conversar."
        )),

        // Localidade 3: Quintal da taberna.
        QUINTAL_DA_TABERNA(new Localidade(
            "Quintal da Taberna", 
            "O quintal da taberna é um lugar aberto, onde os habitantes do vilarejo podem se reunir para conversar e se divertir e se dirigirem para outros locais."
        )),

        // Localidade 4: Fazendinha do taberneiro.
        FAZENDINHA_DO_TABERNEIRO(new Localidade(
            "Fazendinha do Taberneiro", 
            "A fazendinha do taberneiro é um lugar tranquilo, onde o taberneiro cultiva alguns vegetais e cria alguns animais."
        )),

        // Localidade 5: Gaupão da taberna.
        GAUPAO_DA_TABERNA(new Localidade(
            "GAUPAO_DA_TABERNA", 
            "Local onde o taberneiro guarda seus pertences e algumas criaturas gosmentas que ele usa para sua receita."
        )),

        // Localidade 6: Entrada da floresta.
        ENTRADA_FLORESTA(new Localidade(
            "Entrada da Floresta", 
            "A entrada da floresta é um lugar misterioso, onde os aventureiros podem se perder facilmente."
        ));

        // O campo que guarda a referência para a localidade
        private final Localidade referencia;

        // Método construtor
        GM_Localidades(Localidade localidade)
            {
            this.referencia = localidade;
            }

        // Método para retornar a referência
        public Localidade retornar()
            {
            return (referencia);
            }
        }

    // Inicialização das conexões entre localidades e adicionando interagiveis na sala
    // (Bloco Estático)
    static
        {
        //  Aqui será implementada a parte de adicionar interativos pelas localidades.

        // O taberneiro na taberna.
        GM_Localidades.TABERNA.retornar().configurarInteragiveis(new Interagivel[]{
            GM_NPCs.TABERNEIRO.retornar()
        });
        
        
        // O pé de cenoura na fazendinha.
        GM_Localidades.FAZENDINHA_DO_TABERNEIRO.retornar().configurarInteragiveis(new Interagivel[]{
            new PeDeCenoura()
        });


        // Aqui será implementada a lógica para conectar as localidades entre si, permitindo que o herói se mova entre elas.

        // Quarto do herói -> Taberna
        GM_Localidades.QUARTO_DO_HEROI.retornar().configurarCaminhos(new Localidade[]{
            GM_Localidades.TABERNA.retornar()
        });

        // Taberna -> Quarto do herói, Quintal da taberna
        GM_Localidades.TABERNA.retornar().configurarCaminhos(new Localidade[]{
            GM_Localidades.QUARTO_DO_HEROI.retornar(),
            GM_Localidades.QUINTAL_DA_TABERNA.retornar()
        });

        // Quintal da taberna -> Taberna, Fazendinha do taberneiro
        GM_Localidades.QUINTAL_DA_TABERNA.retornar().configurarCaminhos(new Localidade[]{
            GM_Localidades.TABERNA.retornar(),
            GM_Localidades.FAZENDINHA_DO_TABERNEIRO.retornar()
        });

        // Fazendinha do taberneiro -> Quintal da taberna, Entrada da floresta
        GM_Localidades.FAZENDINHA_DO_TABERNEIRO.retornar().configurarCaminhos(new Localidade[]{
            GM_Localidades.QUINTAL_DA_TABERNA.retornar(),
            GM_Localidades.ENTRADA_FLORESTA.retornar()
        });

        // Entrada da floresta -> Fazendinha do taberneiro
        GM_Localidades.ENTRADA_FLORESTA.retornar().configurarCaminhos(new Localidade[]{
            GM_Localidades.FAZENDINHA_DO_TABERNEIRO.retornar()
        });
        }

    // Inicializando as NPC
    public enum GM_NPCs 
        {
        // O Taberneiro.
        TABERNEIRO(new NPC("Taberneiro", 
            new Missao[] {Missao.COLETAR_OVOS, Missao.COLETAR_CENOURAS, Missao.GELATINA_SECRETA}
        ));
        
        // O campo que guarda a referência para a NPC
        private final NPC referencia;

        // Método construtor
        GM_NPCs(NPC npc)
            {
            this.referencia = npc;
            }

        // Método para retornar a referência
        public NPC retornar()
            {
            return (referencia);
            }
        }

    // Configurando as falas dos npcs.
    // (Bloco Estático).
    static {  
        // Configuração dos diálogos do Taberneiro.
        NPC taberneiro = GM_NPCs.TABERNEIRO.retornar();

       // Fala padrão
        taberneiro.configuraDialogoPadrao(
            "Bom dia, bravo herói. Espero que os aposentos da minha taverna tenham sido de seu agrado. Então, deseja seguir para a floresta? Não costumo revelar isso a qualquer um, mas há uma saída pelos fundos da taverna que serve como um atalho  para quem deseja chegar até lá. Eu ficaria feliz em lhe entregar a chave, permitindo que siga livremente para a floresta... porém, preciso de sua ajuda com alguns afazeres aqui na taverna. O que me diz? Se me ajudar, entregarei a chave logo em seguida. Temos um trato?"
        );

        // Se estiver cumprindo a missão 1 ou 2
        taberneiro.adicionarRegraArvoreDecisao(
            h -> h.obterMissaoAtual() == Missao.COLETAR_OVOS || h.obterMissaoAtual() == Missao.COLETAR_CENOURAS,
            "Bem... espero que você tenha sucesso em me ajudar. De tal forma, eu poderei te ajudar em seu caminho."
        );

        // Se já cumpriu a missão 1 e 2, mas ainda não aceitou a terceira
        taberneiro.adicionarRegraArvoreDecisao(
            h -> h.verificarMissoesCompletadas(new Missao[]{Missao.COLETAR_CENOURAS, Missao.COLETAR_OVOS}) && h.obterMissaoAtual() != Missao.GELATINA_SECRETA,
            "Bem... preciso da sua ajuda em algo bastante secreto. Minhas irresistíveis gelatinas são feitas a partir de Slimes que mantenho escondidos no galpão da taverna. Vou abrir a porta para que você possa entrar. Por favor, ajude-me a derrotar alguns Slimes — assim poderei preparar mais da minha deliciosa gelatina."
        );

        // Enquanto a missão três estiver aceita
        taberneiro.adicionarRegraArvoreDecisao(
            h -> h.obterMissaoAtual() == Missao.GELATINA_SECRETA,
            "Então... já conseguiu lidar com os Slimes? Por favor, não revele a ninguém o meu ingrediente secreto."
        );

        // Quando todas as missões estiverem completas
        taberneiro.adicionarRegraArvoreDecisao(
            h -> h.verificarMissoesCompletadas(new Missao[]{Missao.COLETAR_OVOS, Missao.COLETAR_CENOURAS, Missao.GELATINA_SECRETA}),
            "Obrigado pela sua ajuda, herói. Agora que você possui as chaves para a saída dos fundos, acredito que terá grande sucesso em sua jornada. Ainda assim, permaneça atento — o caminho à frente guarda perigos inesperados."
        );
    }

    
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

        // Obtendo as NPCS e elementos do cenário.
        NPC[] _npc_na_localidade            = _localidade_atual.obterNPC();
        int _npc_na_localidade_N = _npc_na_localidade.length;
        ElementosCenario[] _elc_na_localidade = _localidade_atual.obterElementosCenario();
        int _elc_na_localidade_N = _elc_na_localidade.length;

        // Printando as opções de interação para o jogador.

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
                System.out.println(i + " - " +_elc_na_localidade[i].obterNome() +"\n" +"\t\t" +_elc_na_localidade[i].obterDescricao());
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

    // Com as NPCs.
    static void interarNPC()
        {
        //Interagindo com a NPC atual.
        GM_NPC_Agora.interagir(GM_Heroi);
        
        //Lógica de leitura do teclado aqui.
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

                        String _entrada = "";

                        while (!(_entrada.equalsIgnoreCase("Voltar") || _entrada.equalsIgnoreCase("Aceitar")))
                            {
                            // Printando a missão até o usuário fazer uma escolha possível.
                            missao_olhada.desenhar();

                            System.out.println("\nAceitar/Voltar?\n");

                            _entrada = GM_Scanner.nextLine();
                            if (_entrada.equalsIgnoreCase("Voltar"))
                                {
                                //Apenas Voltando para o estado anterior. (falando com a NPC).
                                }
                            else if (_entrada.equalsIgnoreCase("Aceitar"))
                                {
                                // Aceitando a quest.
                                GM_Heroi.aceitaMissao(missao_olhada);
                                }
                            else
                                {
                                //Opisão invalida.
                                System.out.println("Opção inválida!");
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
    

    // Método main da classe.
    public static void main(String[] args)
        {
		
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
        GM_Heroi.mudarLocalidade(GM_Localidades.QUARTO_DO_HEROI.retornar());

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

                default:
                    break;
                }
        
            // Apenas pulando algumas linhas. (estética)
            System.out.println("\n\n\n");
            }
        }
    }