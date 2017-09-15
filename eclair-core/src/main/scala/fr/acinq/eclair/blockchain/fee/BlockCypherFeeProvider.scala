package fr.acinq.eclair.blockchain.fee

import akka.actor.ActorSystem
import fr.acinq.eclair.HttpHelper.get
import org.json4s.JsonAST.JInt

import scala.concurrent.ExecutionContext

class BlockCypherFeeProvider(implicit system: ActorSystem, ec: ExecutionContext) extends FeeProvider {

  override def getFeeratePerKB = for {
    json <- get("https://api.blockcypher.com/v1/btc/test3")
    JInt(fee_per_kb) = json \ "high_fee_per_kb"
  } yield fee_per_kb.longValue()
}
