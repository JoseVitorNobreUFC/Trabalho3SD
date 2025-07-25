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

def get_veterinarios():
    url = f"{BASE_UR}veterinarios"
    try:
        response = requests.get(url)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao buscar veterinários: {e}")
        return None

def create_veterinario(data):
    url = f"{BASE_UR}veterinarios"
    try:
        response = requests.post(url, json=data)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao criar veterinário: {e}")
        return None

def update_veterinario(veterinario_id, data):
    url = f"{BASE_UR}veterinarios/{veterinario_id}"
    try:
        response = requests.put(url, json=data)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao atualizar veterinário {veterinario_id}: {e}")
        return None

def delete_veterinario(veterinario_id):
    url = f"{BASE_UR}veterinarios/{veterinario_id}"
    try:
        response = requests.delete(url)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao deletar veterinário {veterinario_id}: {e}")
        return None

def get_veterinario_by_id(veterinario_id):
    url = f"{BASE_UR}veterinarios/{veterinario_id}"
    try:
        response = requests.get(url)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao buscar veterinário {veterinario_id}: {e}")
        return None

def run_sequence():
    while True:
        print("\nEscolha uma opção:")
        print("1. Listar todos os veterinários")
        print("2. Criar um veterinário")
        print("3. Atualizar um veterinário")
        print("4. Buscar veterinário por ID")
        print("5. Deletar um veterinário")
        print("0. Sair")

        escolha = input("Digite o número da opção desejada: ")

        if escolha == "1":
            veterinarios = get_veterinarios()
            print(json.dumps(veterinarios, indent=2, ensure_ascii=False))

        elif escolha == "2":
            nome = input("Nome do veterinário: ")
            especialidade = input("Especialidade: ")
            data = {
                "id": 0,
                "nome": nome,
                "especialidade": especialidade
            }
            resultado = create_veterinario(data)
            print("Veterinário criado:")
            print(json.dumps(resultado, indent=2, ensure_ascii=False))

        elif escolha == "3":
            veterinario_id = input("ID do veterinário a ser atualizado: ")
            nome = input("Novo nome: ")
            especialidade = input("Nova especialidade: ")
            data = {
                "nome": nome,
                "especialidade": especialidade
            }
            resultado = update_veterinario(veterinario_id, data)
            print("Veterinário atualizado:")
            print(json.dumps(resultado, indent=2, ensure_ascii=False))

        elif escolha == "4":
            veterinario_id = input("ID do veterinário: ")
            resultado = get_veterinario_by_id(veterinario_id)
            print("Veterinário encontrado:")
            print(json.dumps(resultado, indent=2, ensure_ascii=False))

        elif escolha == "5":
            veterinario_id = input("ID do veterinário a ser deletado: ")
            resultado = delete_veterinario(veterinario_id)
            print("Veterinário deletado:")
            print(json.dumps(resultado, indent=2, ensure_ascii=False))

        elif escolha == "0":
            print("Encerrando.")
            break

        else:
            print("Opção inválida. Tente novamente.")


if __name__ == "__main__":
    run_sequence()
