# Prices
Demo prices 

In the company's e-commerce database we have the PRICES table which contains the final price (PVP) and the rate to apply to one product of a brand between a given dates.

## Introduction

### Objetives

Application/Service on SpringBoot that provides a query rest endpoint such as:

Input params: Dates, product Identificator, Brand identificator

Output params: product Identificator, brand identificator, rate to apply, dates and final prices to apply 

## Tecnhologies

Java 11 

SpringBoot 2.7.8 

H2 Database 2.1

Maven 3.5.3 

## Design patterns

Dependency injection

## Release

### Initialization
mvn spring-boot:run

### Test
mvn test



