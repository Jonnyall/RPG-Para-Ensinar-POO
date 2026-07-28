import java.util.ArrayList;

public class Inventario 
    {
    //Esta classe é designada para o inventário dos personagens, ou seja, para os objetos que eles podem carregar e usar durante o jogo.

    //Atributos do inventário.

    //Os itens que o personagem tem no inventário no momento.
    private ArrayList <Item> items;

    //Construtor da classe.
    public Inventario()
        {
        //Apenas inicializando a lista de itens do inventário.
        this.items = new ArrayList <Item>();
        }

    //Metodos para tratar com inventário.

    //Metodo para adicionar um item ao inventário.
    public void adicionarItem(Item item)
        {
        this.items.add(item);
        }
    
    //Metodo para obter o número de itens totais no inventário.
    public int quantidadeItens()
        {
        return (this.items.size());
        }

    //Metodo para obter a quantidade de um item específico no inventário.
    public int quantidadeItemEspecifico(Item item)
        {
        int count = 0;

        for (Item i : this.items)
            {
            if (i.equals(item))
                {
                count++;
                }
            }

        return (count);
        }

    //Metodo para remover um item do inventário.
    public void removerItem(Item item)
        {
        this.items.remove(item);
        }

    //OBSERVAÇÃO: A IMPLEMENTAÇÃO DESTE CLASSE PODE MUDAR DEVIDO A CLASSE ITEM AINDA NÃO ESTA DEFINIDA, SOMADO O FATO DE QUE "intems_in" PODE VIRAR UM ARRAY.
    }

    
