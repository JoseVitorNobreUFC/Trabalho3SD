import requests
import os
import time
import json
from dotenv import load_dotenv

load_dotenv()

BASE_UR = os.getenv("BASE_URL")

def safe_json_response(response):
    if response.content:
        try:
            return response.json()
        except ValueError:
            return {"erro": "Resposta não é um JSON válido."}
    else:
        return {"mensagem": "Operação concluída com sucesso."}

def get_animais():
    url = f"{BASE_UR}animais"
    try:
        response = requests.get(url)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao buscar animais: {e}")
        return None

def create_animal(data, tipo):
    url = f"{BASE_UR}animais/{tipo}"
    try:
        response = requests.post(url, json=data)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao criar animal: {e}")
        return None

def update_animal(animal_id, tipo, data):
    url = f"{BASE_UR}animais/{tipo}/{animal_id}"
    try:
        response = requests.put(url, json=data)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao atualizar animal: {e}")
        return None

def delete_animal(animal_id):
    url = f"{BASE_UR}animais/{animal_id}"
    try:
        response = requests.delete(url)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao deletar animal: {e}")
        return None

def get_animal_by_id(animal_id):    
    url = f"{BASE_UR}animais/{animal_id}"
    try:
        response = requests.get(url)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao buscar animal {animal_id}: {e}")
        return None

def get_animal_by_tipo(tipo):
    url = f"{BASE_UR}animais/tipo/{tipo}"
    try:
        response = requests.get(url)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao buscar animais do tipo {tipo}: {e}")
        return None

def get_animal_by_nome(nome):
    url = f"{BASE_UR}animais/search/{nome}"
    try:
        response = requests.get(url)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao buscar animal com nome {nome}: {e}")
        return None

def run_sequence():
    while True:
        print("\n=== Animal Menu ===")
        print("1. Listar todos os animais")
        print("2. Criar novo animal")
        print("3. Atualizar animal")
        print("4. Buscar animal por ID")
        print("5. Buscar animal por tipo")
        print("6. Buscar animal por nome")
        print("7. Deletar animal")
        print("8. Sair")

        choice = input("Digite o número da operação desejada: ").strip()

        if choice == "1":
            animais = get_animais()
            print("\nTodos os animais:")
            print(json.dumps(animais, indent=2, ensure_ascii=False))

        elif choice == "2":
            try:
                nome = input("Nome do animal: ")
                idade = int(input("Idade do animal: "))
                raca = input("Raça do animal: ")
                tipo = input("Tipo do animal (ex: CACHORRO, GATO): ").strip().upper()
                data = {
                    "id": 0,
                    "nome": nome,
                    "idade": idade,
                    "raca": raca
                }
                resultado = create_animal(data, tipo)
                print("\nAnimal criado:")
                print(json.dumps(resultado, indent=2, ensure_ascii=False))
            except ValueError:
                print("Erro: idade deve ser um número inteiro.")

        elif choice == "3":
            try:
                tipo = input("Tipo do animal procurado (ex: CACHORRO, GATO, PAPAGAIO): ").strip().upper()
                animal_id = int(input("ID do animal a ser atualizado: "))
                nome = input("Novo nome: ")
                idade = int(input("Nova idade: "))
                raca = input("Nova raça: ")
                data = {
                    "nome": nome,
                    "idade": idade,
                    "raca": raca
                }
                resultado = update_animal(animal_id, tipo, data)
                print("\nAnimal atualizado:")
                print(json.dumps(resultado, indent=2, ensure_ascii=False))
            except ValueError:
                print("Erro: IDs e idade devem ser números inteiros.")

        elif choice == "4":
            try:
                animal_id = int(input("ID do animal: "))
                resultado = get_animal_by_id(animal_id)
                print("\nAnimal por ID:")
                print(json.dumps(resultado, indent=2, ensure_ascii=False))
            except ValueError:
                print("Erro: ID deve ser um número inteiro.")

        elif choice == "5":
            tipo = input("Digite o tipo do animal (ex: CACHORRO, GATO, PAPAGAIO): ").strip().upper()
            resultado = get_animal_by_tipo(tipo)
            print("\nAnimais por tipo:")
            print(json.dumps(resultado, indent=2, ensure_ascii=False))

        elif choice == "6":
            nome = input("Digite o nome do animal: ").strip()
            resultado = get_animal_by_nome(nome)
            print("\nAnimal por nome:")
            print(json.dumps(resultado, indent=2, ensure_ascii=False))

        elif choice == "7":
            try:
                animal_id = int(input("ID do animal a ser deletado: "))
                resultado = delete_animal(animal_id)
                print("\nAnimal deletado:")
                print(json.dumps(resultado, indent=2, ensure_ascii=False))
            except ValueError:
                print("Erro: ID deve ser um número inteiro.")

        elif choice == "8":
            print("Saindo...")
            break

        else:
            print("Opção inválida. Tente novamente.")

if __name__ == "__main__":
    run_sequence()
