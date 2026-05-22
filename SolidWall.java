public class SolidWall extends MaterialThings 
    {
    //Esta classe representa as paredes sólidas, aquelas que não podem ser atravessadas pelos personagens.

    //Construtor da classe.
    public SolidWall(int x, int y, int w, int h)
        {
        //Apenas herdando os atributos de posição e dimensão da classe MaterialThings.
        super(x, y, w, h);
        }
    }
