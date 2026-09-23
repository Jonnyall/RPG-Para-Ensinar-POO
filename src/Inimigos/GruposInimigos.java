package src.Inimigos;

import src.TodasAsCoisas;

public class GruposInimigos extends TodasAsCoisas
    {
    // Esta classe representa um grupo de inimigos que podem aparecer juntos em uma batalha.

    // Atributos da classe.

    // Inimigos que podem aparecer juntos em uma batalha. (objetos)
    private Class<? extends Inimigo>[][] inimigos;

    // O array que guarda as intancias dos inimigos. Não os objetos.
    private Inimigo[] inimigosInstanciados;

    // Construtor da classe.
    public GruposInimigos(Class<? extends Inimigo>[][] inimigos)
        {
        this.inimigos = inimigos;
        }

    // Método que sortea um grupo de inimigos aleatoriamente e depois os intancia.
    public void instanciarGrupo()
        {
        // Sorteando um grupo de inimigos aleatoriamente.
        int indice = (int) (Math.random() * inimigos.length);
        
        // Instanciando os inimigos sorteados.
        inimigosInstanciados = new Inimigo[inimigos[indice].length];
        for(int i = 0; i < inimigos[indice].length; i++)
            {
            // 1. Obtém a classe exata do objeto em tempo de execução
            Class<?> classeDoInimigo = inimigos[indice][i].getClass();

            // 2. Cria uma nova instância da classe do inimigo usando o construtor padrão
            try
                {
                inimigosInstanciados[i] = (Inimigo) classeDoInimigo.getDeclaredConstructor().newInstance();
                }
            catch (Exception e)
                {
                e.printStackTrace();
                }
            }
        }

    // Método para obter os inimigos (instanciados).
    public Inimigo[] obterInimigos()
        {
        // Verificando se os inimigos já foram instanciados. Se não, instancia-os.
        if (inimigosInstanciados == null)
            {
            instanciarGrupo();
            }
        
        return (inimigosInstanciados);
        }

    // Método para verificar se o grupo de inimigos é um grupo vazio (ou seja, se não há inimigos).
    public boolean grupoVazio()
        {
        return (this.inimigos == null || this.inimigos.length == 0);
        }

    // Método que diz se os inimigos já foram derrotados (ou seja, se todos os inimigos do grupo estão mortos).
    public boolean todosInimigosDerrotados()
        {
        for(int i = 0; i < inimigosInstanciados.length; i++)
            {
            if (inimigosInstanciados[i].obterVida() > 0)
                {
                return(false);
                }
            }
        return(true);
        }
    
    // Método para verificar se os inimigos já foram instanciados.
    public boolean inimigosInstanciados()
        {
        return (inimigosInstanciados != null);
        }

    // Método para limpar os inimigos instanciados (ou seja, para "resetar" o grupo de inimigos).
    public void limparInimigosInstanciados()
        {
        inimigosInstanciados = null;
        }
    }