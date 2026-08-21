package src.ElementosDeCenario;

import src.Heroi;
import src.Item;
import src.Missao;

public class PuleiroDeGalinha extends ElementosCenario
    {
    // Essa classe representa o puleiro de galinha. O jogador pode tentar coletar ovos, mas corre o risco de levar uma bicada.
    
    // Construtor da classe.
    public PuleiroDeGalinha()
        {
        super("Puleiro de Galinha", "Um puleiro onde as galinhas guardam seus ovos. O jogador pode tentar coletar, mas corre o risco de levar uma bicada.");
        }

    // Método sobreescritor da interface Interagivel, que permite ao jogador interagir com o elemento de cenário.
    @Override
    public void interagir(Heroi heroi)
        {
        // Verificando se o herói está com a missão para coletar ovos ativa.
        if (heroi.obterMissaoAtual() != Missao.COLETAR_OVOS)
            {
            System.out.println("Você só poderá coletar ovos quando tiver aceitado a missão " + Missao.COLETAR_OVOS.obterNome() + ".\n");
            return;
            }

        // Verificando se o herói já tem mais ovos do que são pedidos pela missão.
        if (heroi.possuiItemNoInventarioQuantidade(Item.OVO) >= Missao.COLETAR_OVOS.obterQuantidadeNecessaria(Item.OVO))
            {
            System.out.println("Você já coletou ovos o suficiente.\n");
            return;
            }

        // Gerando um número aleatório entre 0 e 1 para determinar se o jogador conseguiu pegar o ovo ou levou uma bicada.
        int chance = (int) (Math.random() * 2);

        if (chance == 0)
            {
            // O jogador conseguiu pegar o ovo.
            System.out.println("O herói se aproximou do puleiro e conseguiu pegar um ovo!\n");
            heroi.adicionarItemAoInventario(Item.OVO);
            }
        else
            {
            // O jogador levou uma bicada da galinha.
            System.out.println("O herói tentou pegar um ovo, mas a galinha deu uma bicada! Nada de ovo dessa vez...\n");
            }
        }
    }
