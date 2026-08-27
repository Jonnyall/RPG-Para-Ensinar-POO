package src;

import src.ElementosDeCenario.Livro;
import src.ElementosDeCenario.PeDeCenoura;
import src.ElementosDeCenario.PuleiroDeGalinha;

public class Mundo extends TodasAsCoisas
    {
    // Essa classe é responsável por inicializar o "mundo do jogo".

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

    // Método que chama os outros métodos inicializadores.
    public static void inicializar()
        {
        configurarInteragiveis();
        configurarCaminhos();
        configurarDialogos();
        }
            
    // Método que configura os objetos interagíveis do nosso "mundo".
    private static void configurarInteragiveis()
        {
        // Aqui será implementada a parte de adicionar interativos pelas localidades.

        // O diário do herói no quarto dele.
        GM_Localidades.QUARTO_DO_HEROI.retornar().configurarInteragiveis(new Interagivel[]{
            new Livro(
            "Meu diário",
            "sobre a escrivaninha no quarto",
            "anotações pessoais",
            """
            Se alguém estiver lendo isto, provavelmente já descobriu que não sou muito bom em manter um diário.

            Ainda assim, há algumas coisas que preciso registrar.

            Este mundo é estranho. Há pessoas, monstros, cidades, missões e histórias acontecendo ao mesmo tempo. Tudo parece ter seu próprio lugar e sua própria função. Alguns vivem suas próprias vidas, outros aparecem apenas para nos entregar uma missão, e há aqueles que parecem existir apenas para tornar a nossa jornada um pouco mais difícil.

            Às vezes me pergunto quem decidiu que tudo deveria funcionar dessa maneira.

            Quem criou as regras?
            Quem decidiu o que cada pessoa pode fazer?
            Quem determinou que alguns de nós seriam capazes de lutar, enquanto outros apenas conversariam?

            Talvez essas perguntas não tenham importância.

            Talvez exista alguém do outro lado observando tudo isso.

            Se existir...

            Olá.

            Espero que esteja se divertindo.

            E, se você chegou até aqui, talvez seja porque resolveu olhar um pouco mais de perto para este mundo. Então continue. Há muito mais acontecendo por trás dele do que parece.

            — Herói
            """)
        });


        // O taberneiro na taberna.
        GM_Localidades.TABERNA.retornar().configurarInteragiveis(new Interagivel[]{
            GM_NPCs.TABERNEIRO.retornar()
        });


        // O pé de cenoura e o puleiro na fazendinha.
        GM_Localidades.FAZENDINHA_DO_TABERNEIRO.retornar().configurarInteragiveis(new Interagivel[]{
            new PuleiroDeGalinha(),
            new PeDeCenoura()
        });
        }


    // Método que configura os caminhos entre as localidades de tal forma que o herói possa navegar entre elas.
    private static void configurarCaminhos()
        {
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

    // Método que configura os diálogos das NPCs.

    // Configuração dos diálogos do Taberneiro.
    private static void configurarDialogos()
        {
        NPC taberneiro = GM_NPCs.TABERNEIRO.retornar();

        // Fala padrão.
        taberneiro.configuraDialogoPadrao(
            """
            Bom dia, bravo herói.
            
            Espero que os aposentos da minha taverna tenham sido de seu agrado. 
            
            Então, deseja seguir para a floresta? Não costumo revelar isso a qualquer um, mas há uma saída pelos fundos da taverna que serve como um atalho para quem deseja chegar até lá rapidamente. Eu ficaria feliz em lhe entregar a chave, permitindo que siga livremente para a floresta... porém, preciso de sua ajuda com alguns afazeres aqui na taverna. 
            
            Se me ajudar, entregarei a chave logo em seguida. 
            
            Que me diz? Temos um trato?
            """
        );

        // Se estiver cumprindo a missão 1 ou 2
        taberneiro.adicionarRegraArvoreDecisao(
            h -> h.obterMissaoAtual() == Missao.COLETAR_OVOS || h.obterMissaoAtual() == Missao.COLETAR_CENOURAS,
            """
            Bem... Espero que você tenha sucesso em me ajudar. De tal forma, eu poderei te ajudar em seu caminho.
            """
        );

        // Se já cumpriu a missão 1 e 2, mas ainda não aceitou a terceira
        taberneiro.adicionarRegraArvoreDecisao(
            h -> h.verificarMissoesCompletadas(new Missao[]{Missao.COLETAR_CENOURAS, Missao.COLETAR_OVOS}) && h.obterMissaoAtual() != Missao.GELATINA_SECRETA,
            """
            Bem... preciso da sua ajuda em algo bastante secreto. 
            
            Minhas irresistíveis gelatinas são feitas a partir de Slimes que mantenho escondidos no galpão da taverna. Vou abrir a porta para que você possa entrar lá. 
            
            Por favor, ajude-me a derrotar alguns Slimes — assim poderei preparar mais da minha deliciosa gelatina.
            """
        );

        // Enquanto a missão três estiver aceita
        taberneiro.adicionarRegraArvoreDecisao(
            h -> h.obterMissaoAtual() == Missao.GELATINA_SECRETA,
            """
            Então... 
            
            Já conseguiu lidar com os Slimes? Por favor, não revele a ninguém o meu ingrediente secreto.
            """
        );

        // Quando todas as missões estiverem completas
        taberneiro.adicionarRegraArvoreDecisao(
            h -> h.verificarMissoesCompletadas(new Missao[]{Missao.COLETAR_OVOS, Missao.COLETAR_CENOURAS, Missao.GELATINA_SECRETA}),
            """
            Obrigado pela sua ajuda, herói. 
            
            Agora que você possui as chaves para a saída dos fundos, acredito que terá grande sucesso em sua jornada. 
            
            Ainda assim, permaneça atento — o caminho à frente guarda perigos inesperados.
            """
        );

        }
    }