package src;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ArvoreDialogo extends TodasAsCoisas
    {
    // Essa classe é responsável pela decisão do que os NPCs vão falar.
    
    // Atributo da classe.

    // Guarda a lista de regras e diálogos (strings).
    private List<RegraDeDialogo> regras;

    // A resposta padrão, caso nenhuma das regras seja atendida.
    String dialogo_padrao;

    // Método construtor.
    public ArvoreDialogo()
        {
        // Apenas instanciando a lista de regras.
        regras = new ArrayList<>();
        }

    // Método responsável por adicionar uma regra e diálogos à lista.
    public void adicionaRegra(Predicate<Heroi> condicao, String dialogo) 
        {
        regras.add(new RegraDeDialogo(condicao, dialogo));
        }


    // Método para configurar o diálogo padrão.
    public void configuraDialogoPadrao(String dialogo_padrao)
        {
        this.dialogo_padrao = dialogo_padrao;
        }

    // Dada uma regra, testa-se se o herói a cumpre.
    public String obterDialogo(Heroi heroi) 
        {
        for (RegraDeDialogo regra : regras) 
            {
            // Se a condição for validada, retornar a string (o diálogo) desejado.
            if (regra.condicao.test(heroi)) 
                {
                return (regra.dialogo);
                }
            }

        // Se nenhuma das condições for aceita, então se retorna o dialogo padrão.
        return (dialogo_padrao);
        }



    // Subclasse para representar a regra do diálogo.
    private static class RegraDeDialogo 
        {
        // Atributos da subclasse.

        // A condição que precisa ser aceita para se retornar o diálogo.
        Predicate<Heroi> condicao;

        // O diálogo em si.
        String dialogo;

        // Método de construção da subclasse.
        RegraDeDialogo(Predicate<Heroi> condicao, String dialogo)
            {
            this.condicao = condicao;
            this.dialogo = dialogo;
            }
        }
    }
