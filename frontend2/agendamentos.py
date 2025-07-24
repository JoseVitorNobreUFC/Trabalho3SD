import requests
import os
from dotenv import load_dotenv
import time

load_dotenv()

BASE_UR = os.getenv("BASE_URL")

def get_agendamentos():
    url = f"{BASE_UR}/agendamentos"
    try:
        response = requests.get(url)
        response.raise_for_status()  # Raise an error for bad responses
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error fetching agendamentos: {e}")
        return None
    
def create_agendamento(data):
    url = f"{BASE_UR}/agendamentos"
    try:
        response = requests.post(url, json=data)
        response.raise_for_status()  # Raise an error for bad responses
        return response.json()
    except requests.exceptions.RequestException as e:
        return None
    
def update_agendamento(agendamento_id, data):
    url = f"{BASE_UR}/agendamentos/{agendamento_id}"
    try:
        response = requests.put(url, json=data)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        return None
        
def delete_agendamento(agendamento_id):
    url = f"{BASE_UR}/agendamentos/{agendamento_id}"
    try:
        response = requests.delete(url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        return None
    
def get_agendamento_by_id(agendamento_id):
    url = f"{BASE_UR}/agendamentos/{agendamento_id}"
    try:
        response = requests.get(url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error fetching agendamento {agendamento_id}: {e}")
        return None
    
def run_sequence():
    created_data = {
        "id": 0,
        "animal": 1,
        "veterinario": 4,
        "data": "2023-10-01"
    }
    
    created_agendamento = create_agendamento(created_data)
    print(f"Agendamento criado")
    
    time.sleep(1)
    agendamentos = get_agendamentos()
    print(f"Agendamentos obtidos: {agendamentos}")
    updated_data = {
        "animal": 4,
        "veterinario": 4,
        "data": "2023-10-02"
    }
    
    time.sleep(1)
    update_agendamento(2, updated_data)
    print(f"Agendamento atualizado")
    
    time.sleep(1)
    agendamento = get_agendamento_by_id(2)
    print(f"Agendamento obtido por ID: {agendamento}")
    
    time.sleep(1)
    delete_agendamento(2)
    print(f"Agendamento deletado")
    
    time.sleep(1)
    agendamentos = get_agendamentos()
    print(f"Agendamentos obtidos após deleção: {agendamentos}")
    
if __name__ == "__main__":
    run_sequence()