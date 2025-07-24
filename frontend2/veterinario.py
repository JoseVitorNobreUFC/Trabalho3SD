import requests
import os
from dotenv import load_dotenv
import time

load_dotenv()

BASE_UR = os.getenv("BASE_URL")

def get_veterinarios():
    url = f"{BASE_UR}/veterinarios"
    try:
        response = requests.get(url)
        response.raise_for_status() 
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error fetching veterinarios: {e}")
        return None
    
def create_veterinario(data):
    url = f"{BASE_UR}/veterinarios"
    try:
        response = requests.post(url, json=data)
        response.raise_for_status()  
        return response.json()
    except requests.exceptions.RequestException as e:
        return None

def update_veterinario(veterinario_id, data):
    url = f"{BASE_UR}/veterinarios/{veterinario_id}"
    try:
        response = requests.put(url, json=data)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        return None
    
def delete_veterinario(veterinario_id):
    url = f"{BASE_UR}/veterinarios/{veterinario_id}"
    try:
        response = requests.delete(url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        return None
    
def get_veterinario_by_id(veterinario_id):    
    url = f"{BASE_UR}/veterinarios/{veterinario_id}"
    try:
        response = requests.get(url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error fetching veterinario {veterinario_id}: {e}")
        return None

def run_sequence():
    created_data = {
        "id": 0,
        "nome": "Dr. Smith",
        "especialidade": "Cirurgia",
    }
    
    created_veterinario = create_veterinario(created_data)
    print(f"Veterinario criado")
    
    time.sleep(1)          
    veterinarios = get_veterinarios()
    print(f"Veterinarios obtidos: {veterinarios}")
    
    updated_data = {
        "nome": "Dr. John Smith",
        "especialidade": "Cirurgia em Cachorros",
    }
    
    time.sleep(1)
    update_veterinario(6, updated_data)
    print(f"Veterinario atualizado")
    
    time.sleep(1)
    veterinario = get_veterinario_by_id(6)
    print(f"Veterinario obtido por ID: {veterinario}")
    
    time.sleep(1)
    delete_veterinario(6)
    print(f"Veterinario deletado")
    
    time.sleep(1)
    veterinarios = get_veterinarios()
    print(f"Veterinarios obtidos após deleção: {veterinarios}")
        
if __name__ == "__main__":
    run_sequence()