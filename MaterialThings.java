
public abstract class MaterialThings extends AllThings
    {
    //Esta classe é a classe designada para objetos "físicos", aqueles que ocupam espaço.

    //Posição do objeto.
    private int x;
    private int y;

    //Dimensões do objeto.
    private int w;
    private int h;

    //Construtor da classe.
    public MaterialThings(int x, int y, int w, int h)
        {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        }

    //Getters e setters para as variáveis de posição e dimensão.
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


    //Metodos para mover o objeto.
    public void plussX(int plus)
        {
        this.x += plus;
        }

    public void plussY(int plus)
        {
        this.y += plus;
        }

    //Metodo para verificar se o objeto colidiu com outro.

    //Versão 1: Verificar se o objeto colidiu com outro em uma posição específica (x e y).
    public boolean checkCollision(MaterialThings other, int x, int y)
        {
        if ((x + this.w > other.getX()) && (x < other.getX() + other.getW()) && (y + this.h > other.getY()) && (y < other.getY() + other.getH()))
            {
            return (true);
            }
        else
            {
            return (false);
            }
        }

    //Versão 2: Verificar se o objeto colidiu com outro usando a posição atual do objeto.
    public boolean checkCollision(MaterialThings other)
        {
        return (checkCollision(other, this.x, this.y));
        }
    }
