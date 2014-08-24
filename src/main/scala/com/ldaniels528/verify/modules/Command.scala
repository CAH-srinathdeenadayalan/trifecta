package com.ldaniels528.verify.modules

/**
 * Represents an Verify Shell command
 * @author lawrence.daniels@gmail.com
 */
case class Command(module:Module, name: String, fx: Seq[String] => Any, params: (Seq[String], Seq[String]) = (Seq.empty, Seq.empty), help: String = "") {

  def prototype = {
    val required = (params._1 map (s => s"<$s>")).mkString(" ")
    val optional = (params._2 map (s => s"<$s>")).mkString(" ")
    s"$name $required ${if (optional.nonEmpty) s"[$optional]" else ""}"
  }
}