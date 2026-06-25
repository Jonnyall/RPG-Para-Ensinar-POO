import java.util.ArrayList;

public class Inventory 
    {
    //Esta classe é designada para o inventário dos personagens, ou seja, para os objetos que eles podem carregar e usar durante o jogo.

    //Atributos do inventário.

    //Os itens que o personagem tem no inventário no momento.
    private ArrayList <Item> items_in;

    //Construtor da classe.
    public Inventory()
        {
        //Apenas inicializando a lista de itens do inventário.
        items_in = new ArrayList <Item>();
        }

    //Metodos para tratar com inventário.

    //Metodo para adicionar um item ao inventário.
    public void addItem(Item item)
        {
        items_in.add(item);
        }
    
    //Metodo para obter o número de itens totais no inventário.
    public int getNumberItems()
        {
        return (items_in.size());
        }

    //Metodo para obter a quantidade de um item específico no inventário.
    public int getNumberItem(Item item)
        {
        int count = 0;

        for (Item i : items_in)
            {
            if (i.equals(item))
                {
                count++;
                }
            }

        return (count);
        }

    //Metodo para remover um item do inventário.
    public void removeItem(Item item)
        {
        items_in.remove(item);
        }

    //OBSERVAÇÃO: A IMPLEMENTAÇÃO DESTE CLASSE PODE MUDAR DEVIDO A CLASSE ITEM AINDA NÃO ESTA DEFINIDA, SOMADO O FATO DE QUE "intems_in" PODE VIRAR UM ARRAY.
    }

    
