import requests
import os
import json
from dotenv import load_dotenv
import time

load_dotenv()
BASE_URL = os.getenv("BASE_URL")

def safe_json_response(response):
    try:
        return response.json()
    except ValueError:
        print("Erro ao decodificar JSON da resposta.")
        return {"error": "Invalid JSON response"}

def get_estoque():
    url = f"{BASE_URL}estoque/todos"
    try:
        response = requests.get(url)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao buscar estoque: {e}")
        return None

def get_by_animal(tipo):
    url = f"{BASE_URL}estoque/{tipo}"
    try:
        response = requests.get(url)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao buscar estoque por tipo {tipo}: {e}")
        return None

def get_by_name(nome):
    url = f"{BASE_URL}estoque/buscar?nome={nome}"
    try:
        response = requests.get(url)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao buscar estoque por nome {nome}: {e}")
        return None

def rmv_of_estoque(tipo, nome, quantidade):
    url = f"{BASE_URL}estoque/{tipo}/aplicar?nome={nome}&quantidade={quantidade}"
    try:
        response = requests.post(url)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao remover do estoque: {e}")
        return None

def add_to_estoque(tipo, nome, quantidade):
    url = f"{BASE_URL}estoque/{tipo}/adicionar?nome={nome}&quantidade={quantidade}"
    try:
        response = requests.post(url)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao adicionar ao estoque: {e}")
        return None

def update_name_estoque(tipo, nome, novo_nome):
    url = f"{BASE_URL}estoque/{tipo}/editar-nome?antigo={nome}&novo={novo_nome}"
    try:
        response = requests.put(url)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao atualizar nome no estoque: {e}")
        return None

def run_sequence():
    while True:
        print("\n=== Estoque Menu ===")
        print("1. Ver estoque completo")
        print("2. Buscar por tipo de animal")
        print("3. Buscar por nome")
        print("4. Adicionar item")
        print("5. Remover item")
        print("6. Atualizar nome de item")
        print("7. Sair")
        choice = input("Escolha uma opção: ")

        if choice == "1":
            estoque = get_estoque()
            print("Estoque:", json.dumps(estoque, indent=2, ensure_ascii=False))
        elif choice == "2":
            tipo = input("Tipo do animal: ")
            estoque = get_by_animal(tipo)
            print(f"Estoque ({tipo}):", json.dumps(estoque, indent=2, ensure_ascii=False))
        elif choice == "3":
            nome = input("Nome do item: ")
            estoque = get_by_name(nome)
            print(f"Resultado para '{nome}':", json.dumps(estoque, indent=2, ensure_ascii=False))
        elif choice == "4":
            tipo = input("Tipo do animal: ")
            nome = input("Nome do item: ")
            quantidade = input("Quantidade: ")
            result = add_to_estoque(tipo, nome, quantidade)
            print("Adição:", result)
        elif choice == "5":
            tipo = input("Tipo do animal: ")
            nome = input("Nome do item: ")
            quantidade = input("Quantidade a remover: ")
            result = rmv_of_estoque(tipo, nome, quantidade)
            print("Remoção:", result)
        elif choice == "6":
            tipo = input("Tipo do animal: ")
            nome = input("Nome atual do item: ")
            novo_nome = input("Novo nome: ")
            result = update_name_estoque(tipo, nome, novo_nome)
            print("Atualização:", result)
        elif choice == "7":
            print("Saindo...")
            break
        else:
            print("Opção inválida.")

if __name__ == "__main__":
    run_sequence()
