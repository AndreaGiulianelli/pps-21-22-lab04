package u04lab.polyglot.a01b

import u04lab.polyglot.Pair
import u04lab.polyglot.*
import u04lab.code.Option.*
import u04lab.code.List
import u04lab.code.List.*

/*
   * Scopo di questo esercizio è realizzare una GUI con l'aspetto mostrato nell'immagine fig.png, fornita,
   * che realizza una mini-versione di Campo Minato. All'avvio si prepara un campo di gara quadrato
   * (dimensione indicata dal primo parametro del costruttore), e si collocano in modo random le mine (in numero
   * indicato nel secondo parametro) facendo attenzioni che siano in posizioni distinte
   * (si stampi su console la loro posizione, a fini di debug).
   * Alla pressione di un pulsante, questo si disabilita: se contiene una mina si esca indicando la sconfitta,
   * altrimenti si mostri sul pulsante quante mine sono presenti in un vicino della cella clickata
   * (in orizzontale, verticale o diagonale).
   * Colpite tutte le celle che non hanno delle mine, si avrà vinto: si produca una stampa a console e si esca.\

  Step:
    - colloca le mine all'inizio in modo random in posizioni DISTINTE, stampando le posizioni
    - disabilitare il pulsante quando premuto
    - controllo se il pulsante contiene mina -> in caso esci sconfitto
    - mostra in caso corretto il numero di vicini (orr, vert, diag)
    - check rimanenti solo mine -> vittoria
*/

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01b/sol2/ */
class LogicsImpl(private val size: Int, private val mines: Int) extends Logics:
  private val minesList: List[Pair[Int, Int]] = Nil()

  def hit(x: Int, y: Int): java.util.Optional[Integer] =
    OptionToOptional(None()) // Option => Optional converter

  def won = false
