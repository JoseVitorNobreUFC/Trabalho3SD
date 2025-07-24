import requests
import os
from dotenv import load_dotenv
import time

load_dotenv()

BASE_UR = os.getenv("BASE_URL")

def get_estoque():
    url = f"{BASE_UR}/estoque/todos"
    try:
        response = requests.get(url)
        response.raise_for_status()  # Raise an error for bad responses
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error fetching estoque: {e}")
        return None
    
def get_by_animal(tipo):
    url = f"{BASE_UR}/estoque/{tipo}"
    try:
        response = requests.get(url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error fetching estoque by animal type {tipo}: {e}")
        return None
    
def get_by_name(nome):
    url = f"{BASE_UR}/estoque/buscar/{nome}"
    try:
        response = requests.get(url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error fetching estoque by name {nome}: {e}")
        return None

def rmv_of_estoque(tipo, nome, quantidade):
    url = f"{BASE_UR}/estoque/{tipo}/aplicar?nome={nome}&quantidade={quantidade}"
    try: 
        response = requests.post(url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error removing from estoque: {e}")
        return None
    
def add_to_estoque(tipo, nome, quantidade):
    url = f"{BASE_UR}/estoque/{tipo}/adicionar?nome={nome}&quantidade={quantidade}"
    try:
        response = requests.post(url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error adding to estoque: {e}")
        return None

def update_name_estoque(tipo, nome, novo_nome):
    url = f"{BASE_UR}/estoque/{tipo}/editar-nome?antigo={nome}&novo={novo_nome}"
    try:
        response = requests.post(url)
        response.raise_for_status()
        return response.json()
    except requests.exceptions.RequestException as e:
        return None

def run_sequence():
    add_to_estoque("GATO", "Catnip", 50)
    time.sleep(1)
    
    estoque = get_estoque()
    print(f"Estoque: {estoque}")
    
    time.sleep(1)