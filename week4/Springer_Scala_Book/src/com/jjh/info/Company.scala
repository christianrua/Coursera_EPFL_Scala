package com.jjh.info

class Company {
  var name = ""
  var address = ""
  var telephone = "0000"
  var registrationNumber = "000"
  var vatNumber = "xxxx"
  var postcode = "xxx xxx"

  def print() = println(s"Company name $name at $address")

  override def toString = s"Company[$name, $address, " +
    s"$telephone, $registrationNumber, $vatNumber" +
    s"$postcode]"
}
