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

def get_agendamentos():
    url = f"{BASE_UR}agendamentos"
    try:
        response = requests.get(url)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao buscar agendamentos: {e}")
        return None

def create_agendamento(data):
    url = f"{BASE_UR}agendamentos"
    try:
        response = requests.post(url, json=data)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao criar agendamento: {e}")
        return None

def update_agendamento(agendamento_id, data):
    url = f"{BASE_UR}agendamentos/{agendamento_id}"
    try:
        response = requests.put(url, json=data)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao atualizar agendamento: {e}")
        return None

def delete_agendamento(agendamento_id):
    url = f"{BASE_UR}agendamentos/{agendamento_id}"
    try:
        response = requests.delete(url)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao deletar agendamento: {e}")
        return None

def get_agendamento_by_id(agendamento_id):
    url = f"{BASE_UR}agendamentos/{agendamento_id}"
    try:
        response = requests.get(url)
        response.raise_for_status()
        return safe_json_response(response)
    except requests.exceptions.RequestException as e:
        print(f"Erro ao buscar agendamento {agendamento_id}: {e}")
        return None

def run_sequence():
    while True:
        print("\n=== Agendamento Menu ===")
        print("1. Listar agendamentos")
        print("2. Criar agendamento")
        print("3. Atualizar agendamento")
        print("4. Buscar agendamento por ID")
        print("5. Deletar agendamento")
        print("6. Sair")
        
        choice = input("Digite o número da operação desejada: ").strip()

        if choice == "1":
            agendamentos = get_agendamentos()
            print("\nAgendamentos:")
            print(json.dumps(agendamentos, indent=2, ensure_ascii=False))

        elif choice == "2":
            try:
                animal = int(input("ID do animal: "))
                veterinario = int(input("ID do veterinário: "))
                data = input("Data (YYYY-MM-DD): ")
                data_agendamento = {
                    "id": 0, 
                    "animal": animal,
                    "veterinario": veterinario,
                    "data": data
                }
                resultado = create_agendamento(data_agendamento)
                print("\nAgendamento criado:")
                print(json.dumps(resultado, indent=2, ensure_ascii=False))
            except ValueError:
                print("Erro: IDs devem ser números inteiros.")

        elif choice == "3":
            try:
                agendamento_id = int(input("ID do agendamento a ser atualizado: "))
                animal = int(input("Novo ID do animal: "))
                veterinario = int(input("Novo ID do veterinário: "))
                data = input("Nova data (YYYY-MM-DD): ")
                updated_data = {
                    "animal": animal,
                    "veterinario": veterinario,
                    "data": data
                }
                resultado = update_agendamento(agendamento_id, updated_data)
                print("\nAgendamento atualizado:")
                print(json.dumps(resultado, indent=2, ensure_ascii=False))
            except ValueError:
                print("Erro: IDs devem ser números inteiros.")

        elif choice == "4":
            try:
                agendamento_id = int(input("ID do agendamento: "))
                resultado = get_agendamento_by_id(agendamento_id)
                print("\nResultado:")
                print(json.dumps(resultado, indent=2, ensure_ascii=False))
            except ValueError:
                print("Erro: ID deve ser um número inteiro.")

        elif choice == "5":
            try:
                agendamento_id = int(input("ID do agendamento a ser deletado: "))
                resultado = delete_agendamento(agendamento_id)
                print("\nAgendamento deletado:")
                print(json.dumps(resultado, indent=2, ensure_ascii=False))
            except ValueError:
                print("Erro: ID deve ser um número inteiro.")

        elif choice == "6":
            print("Saindo...")
            break

        else:
            print("Opção inválida. Tente novamente.")

if __name__ == "__main__":
    run_sequence()
