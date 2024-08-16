<h1> Text-based RPG com Java </h1>
Projeto desenvolvido para aplicar os conceitos de POO, da cadeira de Programação Orientada a Objetos, do IFSul Charqueadas.

<h2> Conceitos aplicados </h2>
<ul>
  <li>
    <p>
    <b> Classes e objetos: </b> as principais classes do projeto são Player, Character, Enemy, EnemyFactory, Weapon, HealingItem, FileHandler e Logger. Instâncias dessas classes (objetos), representam diferentes entidades, como o jogador, armas, itens de cura, gerenciador de arquivos, etc, que são necessárias para o funcionamento do jogo. <br> Por exemplo, a classe Character, serve como base para a criação das classes Enemy e Player, e apresenta <b>atributos</b>  como nome, pontos de vida, poder de ataque, etc, e <b>métodos</b> para recuperar a vida do personagem e atacar outro personagem.
  </p>
  </li>
  <li>
    <p>
      <b> Encapsulamento: </b> pegando a classe Character como exemplo, os atributos 'name', 'healthPoints' e 'maxHealthPoints' são privados, isto é, são acessíveis apenas dentro da própria classe Character. Para visualisar as informações destes atributos fora da classe, foram criados métodos públicos, como 'getName', 'getHealthPoints' e 'getMaxHealthPoints'.
    </p>
  </li>
  <li>
    <p>
      <b> Herança </b>: a principal superclasse do projeto é a classe Character. As subclasses, Enemy e Player, herdam todos os atributos e métodos de sua superclasse, mas também implementam funcionalidades próprias. Player, por exemplo, possui métodos como 'healingItens' e 'equipWeapon', que são próprios do jogador. A classe Enemy, por sua vez, tem um método exclusivo que é 'dropGold'.
    </p>
  </li>
  <li>
    <p>
      <b> Sobrecarga de métodos: </b> na classe Inventory, a sobrecarga ocorre nos métodos 'storeItem', onde há duas versões do método: uma que aceita um parâmetro do tipo HealingItem e outra que aceita um Weapon. Ambas as versões têm o mesmo nome, mas diferentes assinaturas (diferentes tipos de parâmetros), permitindo o armazenamento de itens de cura e armas no inventário usando o mesmo nome de método, mas com funcionalidades distintas dependendo do tipo de item.
    </p>
  </li>
  <li>
    <p>
      <b> Interfaces: </b> as interfaces Weapon e HealingItem definem contratos para armas e itens de cura, respectivamente. Por exemplo, a interface HealingItem exige a implementação de métodos como 'getHealingAmount' e 'getDescription', enquanto Weapon exige 'getAttackPower'.
    </p>
  </li>
  <li>
    <p>
      <b> Coleções: </b> na classe Inventory, responsável por gerenciar o inventário do jogador, temos dois atributos do tipo ArrayList, 'healingItens' e 'weapons'. Nos métodos 'storeItem' da mesma classe, fazemos uso do método 'add' da ArrayList para adicionar itens ao inventário. 
    </p>
  </li>
  <li>
    <p>
      <b> Manipulação de arquivos: </b> a classe FileManager é responsável por realizar a leitura de arquivos de texto e retornar seu conteúdo. Utilizamos esta classe para ler os arquivos de texto que descrevem as cenas do jogo, para em seguida exibir seu conteúdo no terminal.
    </p>
  </li>
  <li>
    <p>
      <b> Tratamento de exceções </b> no método 'readFileText' da classe FileManager, utilizamos um bloco try/catch para tratar possíveis erros na leitura dos arquivos. Realizamos tratamento de exceções nos métodos 'getHealingItem' e 'getWeapon' da classe Inventory.
    </p>
  </li>
</ul>
