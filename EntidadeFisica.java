
public abstract class EntidadeFisica extends AllThings
    {
    //Esta classe é a classe designada para objetos "físicos", aqueles que ocupam espaço.

    //Posição do objeto.
    private int x;
    private int y;

    //Dimensões do objeto.
    private int w;
    private int h;

    //Construtor da classe.
    public EntidadeFisica(int x, int y, int w, int h)
        {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        }

    //Getters e setters para as variáveis de posição e dimensão.
    /* 
    public int getX()
        {
        return (x);
        }

    public int getY()
        {
        return (y);
        }

    public int getW()
        {
        return (w);
        }

    public int getH()
        {
        return (h);
        }
    */

    //Metodos para mover o objeto.
    public void deslocarEmX(int soma)
        {
        this.x += soma;
        }

    public void deslocarEmY(int soma)
        {
        this.y += soma;
        }

    //Metodo para verificar se o objeto colidiu com outro.

    //Versão 1: Verificar se o objeto colidiu com outro em uma posição específica (x e y).
    public boolean checarColisao(EntidadeFisica other, int x, int y)
        {
        if (this.x > other.x
            && this.x < other.x + other.w
            && this.y > other.y
            && this.y < other.y + other.h)
            {
            return (true);
            }
        else
            {
            return (false);
            }
        }

    //Versão 2: Verificar se o objeto colidiu com outro usando a posição atual do objeto.
    public boolean checarColisao(EntidadeFisica other)
        {
        return (checarColisao(other, this.x, this.y));
        }
    }
