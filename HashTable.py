# Dicionário com atributos 
thisDict = {
    "Personagem": "Sonic",              
    "Jogo": "Sonic the Hedgehog",       
    "Cor": "Azul",                       
    "Velocidade": 900000                    
}
print(thisDict)

# conjunto mutável
mySet = {"Mario Kart", "F-Zero", "Out Run", "Pac-Man", "Tetris"} 
mySet.add(thisDict["Jogo"])  # Adiciona ao conjunto o jogo associado ao personagem
print(mySet)

# Verificar se o jogo do personagem está no conjunto e achar o personagem
if thisDict["Jogo"] in mySet:
    print(f"O personagem {thisDict['Personagem']} está associado ao jogo {thisDict['Jogo']}, que está no conjunto!")
else:
    print(f"O jogo {thisDict['Jogo']} não foi encontrado no conjunto.")

# Lista imutável
# não pode ser alterada após a criação
myFrozenSet = (["Street Fighter", "Mortal Kombat", "Double Dragon", "Killer Instinct", "Tekken"])
print(myFrozenSet)