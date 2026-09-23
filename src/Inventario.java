package src;
import java.util.ArrayList;

public class Inventario extends TodasAsCoisas
    {
    // Esta classe é designada para o inventário dos personagens, ou seja, para os objetos que eles podem carregar e usar durante o jogo.

    // Atributos do inventário.

    // Os itens que o personagem tem no inventário no momento.
    private ArrayList <Item> items;

    // Construtor da classe.
    public Inventario()
        {
        // Apenas inicializando a lista de itens do inventário.
        this.items = new ArrayList <Item>();
        }

    // Métodos para lidar com o inventário.

    // Método para adicionar um item ao inventário.
    public void adicionarItem(Item item)
        {
        this.items.add(item);
        }
    
    // Método para obter o número de itens totais no inventário.
    public int quantidadeItens()
        {
        return (this.items.size());
        }

    // Método que retorna um item específico do inventário, dado o índice do item.
    public Item obterItem(int indice)
        {
        // Verificando se o índice é válido.
        if (indice < 0 || indice >= this.items.size())
            {
            System.out.println("Índice inválido. Retornando null.");
            return (null);
            }
        
        return (this.items.get(indice));
        }

    // Método para obter a quantidade de um item específico no inventário.
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

    // Método para remover um item do inventário.
    public void removerItem(Item item)
        {
        this.items.remove(item);
        }
    }

    
