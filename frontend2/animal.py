import requests
import os
from dotenv import load_dotenv
import time
load_dotenv()

BASE_UR = os.getenv("BASE_URL")

def get_animais():
    url = f"{BASE_UR}/animais"
    try:
        response = requests.get(url)
        response.raise_for_status()  # Raise an error for bad responses
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error fetching animais: {e}")
        return None
    
def create_animal(data, tipo):
    url = f"{BASE_UR}/animais/{tipo}"
    try:
        response = requests.post(url, json=data)
        response.raise_for_status()  # Raise an error for bad responses
        return response.json()
    except requests.exceptions.RequestException as e:
        return None
    
def update_animal(animal_id, tipo, data):
    url = f"{BASE_UR}/animais/{tipo}/{animal_id}"
    try:
        response = requests.put(url, json=data)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        return None
        
def delete_animal(animal_id):
    url = f"{BASE_UR}/animais/{animal_id}"
    try:
        response = requests.delete(url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        return None
    
def get_animal_by_id(animal_id):    
    url = f"{BASE_UR}/animais/{animal_id}"
    try:
        response = requests.get(url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error fetching animal {animal_id}: {e}")
        return None
    
def get_animal_by_tipo(tipo):
    url = f"{BASE_UR}/animais/tipo/{tipo}"
    try:
        response = requests.get(url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error fetching animals by type {tipo}: {e}")
        return None
    
def get_animal_by_nome(nome):
    url = f"{BASE_UR}/animais/search/{nome}"
    try:
        response = requests.get(url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error fetching animal by name {nome}: {e}")
        return None
    
def run_sequence():
    created_data = {
        "id": 0,
        "nome": "Rex",
        "idade": 5,
        "raca": "Labrador"
    }
    tipo = "CACHORRO"
    create_animal(created_data, tipo)
    print(f"Animal criado")
    
    time.sleep(1)
    all_animals = get_animais()
    print(f"Todos os animais: {all_animals}")
    
    time.sleep(1)
    updated_data = {
        "nome": "Rex Atualizado",
        "idade": 6,
        "raca": "Labrador"
    }
    update_animal(5, "CACHORRO",updated_data)
    print(f"Animal atualizado")
    
    time.sleep(1)
    animal_by_id = get_animal_by_id(5)
    print(f"Animal por ID: {animal_by_id}")
    
    time.sleep(1)
    animal_by_tipo = get_animal_by_tipo("CACHORRO")
    
    time.sleep(1)
    animal_by_nome = get_animal_by_nome("Rex")
    
    time.sleep(1)
    delete_animal(5)
    
    print(f"Animal deletado")
    
    time.sleep(1)
    all_animals = get_animais()
    print(f"Todos os animais após deleção: {all_animals}")
    
if __name__ == "__main__":
    run_sequence()