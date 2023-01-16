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

## Project explanation
This repository follows the Hexagonal Architecture pattern. The target is to isolate the domain layer, which holds the business logic, from the application and infrastructure layers. It's structured using the following layers:

![image](https://user-images.githubusercontent.com/32063255/212756862-a207f1dc-1aed-4f6a-a241-42cc6f088d93.png)

Primary Adapter: API REST Controller

Secondary Adapter: H2 Database Repository

## Release

### Initialization
mvn spring-boot:run

### Test
mvn test



