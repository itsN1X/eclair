package fr.acinq.eclair.blockchain.fee

import scala.concurrent.Future

/**
  * Created by PM on 09/07/2017.
  */
trait FeeProvider {

  /**
    *
    * @return a fee estimate for quick inclusion in the blockchain, in satoshi/kilobyte
    */
  def getFeeratePerKB: Future[Long]

}
