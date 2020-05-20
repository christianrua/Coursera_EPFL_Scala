package com.jjh.info

object CompanyTestApp extends App {
  println("Starting CompanyTestApp")
  val company = new Company()

  // Set up the company information
  company.name = "Putrid Corporation Sys"
  company.address = "Coldharbour Street, London"
  company.telephone = "123456"
  company.registrationNumber = "99999999"
  company.vatNumber = "BB112233AA"
  company.postcode = "BS16 1QY"

  company.print
  println(company)
  println("Done CompanyTestApp")
}
