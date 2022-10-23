# Dicerolling
  Ohjelma, joka laskee erilaisten noppien heiton tulosten todennäköisyyden.


# Rakenne
  Ohjelma on kirjoitettu Eclipse-ohjelmointiympäristössä, ja koostuu seuraavista luokista:

  -Main: Luokka, jonka kautta ohjelma toteutetaan.
  
  -Fraction: Luokka, jossa määritellään todennäköisyyksien laskemisessa käytettävät murtoluvut
  
  -Die: Luokka, jossa noppa määritellään kahdella muuttujalla: 
  
      -Sivut: kokonaislukuja, joita voidaan saada nopanheiton arvoksi
      
      -Todennäköisyydet: murtolukuja, joilla ilmaistaan nopan sivun todennäköisyys nopanheitossa
      
   Nopan sivujen oletusmäärä on kuusi, ja oletetut sivujen todennäköisyydet ovat samanarvoisia. 
   Nopalle voidaan valita oletuksesta poikkeavat sivut ja niitä vastaavat todennäköisyydet. 
   
   Ohjelmassa käytetyt kirjastot:
    java.math.BigDecimak
    java.math.MathContext
   

# Esimerkki ohjelman toteutuksesta:

  -Main-tiedoston koodi:

    Die d6 = new Die();
    System.out.println(d6.multiply(3).showAllProbabilities());

  -Ohjelma tulostaa:

    p(3): 1/216: 0.004629630
    p(4): 3/216: 0.01388889
    p(5): 6/216: 0.02777778
    p(6): 10/216: 0.04629630
    p(7): 15/216: 0.06944444
    p(8): 21/216: 0.09722222
    p(9): 25/216: 0.1157407
    p(10): 27/216: 0.125
    p(11): 27/216: 0.125
    p(12): 25/216: 0.1157407
    p(13): 21/216: 0.09722222
    p(14): 15/216: 0.06944444
    p(15): 10/216: 0.04629630
    p(16): 6/216: 0.02777778
    p(17): 3/216: 0.01388889
    p(18): 1/216: 0.004629630
