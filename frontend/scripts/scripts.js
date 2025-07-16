const setFormsAdd = {
        addMedicamento:{ 
            animal:{
                For: "animal",
                Text: "Tipo de animal",
                Type:"text",
                Id: "animal",
                Name: "animal",
                Placeholder: "Digite o tipo de animal",
            },
            nome:{
                For: "medicamento",
                Text: "Nome do medicamento",
                Type:"text",
                Id: "medicamento",
                Name: "medicamento",
                Placeholder: "Digite o nome do medicamento",
            },
            quantidade:{
                For: "qtd",
                Text: "Quantidade de medicamento",
                Type:"number",
                Id: "qtd",
                Name: "qtd",
                Placeholder: "Digite a quantidade de medicamento",
            }
        },
        addAnimal:{
            nome:{
                For: "nome",
                Text: "Nome do animal",
                Type:"text",
                Id: "nome",
                Name: "nome",
                Placeholder: "Digite o nome do animal",
            },
            idade:{
                For: "idade",
                Text: "Idade do animal",
                Type:"number",
                Id: "idade",
                Name: "idade",
                Placeholder: "Digite a idade do animal",
            },
            raca:{
                For: "raca",
                Text: "Raça do animal",
                Type:"text",
                Id: "raca",
                Name: "raca",
                Placeholder: "Digite a raça do animal",
            },
            tipo:{
                For: "tipo",
                Text: "Tipo do animal",
                Type:"text",
                Id: "tipo",
                Name: "tipo",
                Placeholder: "Digite o tipo do animal",
            },
        },
        addVeterinario:{ 
            nome:{
                For: "nome",
                Text: "Nome do veterinário",
                Type:"text",
                Id: "nome",
                Name: "nome",
                Placeholder: "Digite o nome do veterinário",
            },
            especialidade:{
                For: "especialidade",
                Text: "Especialidade",
                Type:"text",
                Id: "especialidade",
                Name: "especialidade",
                Placeholder: "Digite a especialidade do veterinário",
            },
        },
        addAgendamento:{
            data:{
                For: "data",
                Text: "Data do agendamento",
                Type:"date",
                Id: "data",
                Name: "data",
                Placeholder: ""
            },
            animal:{
                For: "animal",
                Text: "id do animal",
                Type:"number",
                Id: "animal",
                Name: "animal",
                Placeholder: "Digite o id do animal",
            },
            veterinario:{
                For: "veterinario",
                Text: "id do veterinário",
                Type:"number",
                Id: "veterinario",
                Name: "veterinario",
                Placeholder: "Digite o id do veterinário",
            }
        }
    };

setFormsGet = {

}

document.querySelectorAll('.containerButtons').forEach(div => {
    div.addEventListener('click', function(event) {
        if (event.target.tagName === 'BUTTON') {
            console.log('Botão pressionado:', event.target.id);
            // Aqui você pode executar a ação desejada
            document.getElementById("formAdd").innerHTML = ""; // Limpa o container antes de adicionar novo formulário
            
            switch(event.target.id) {
                case "addMedicamento":
                    
                    for (const key in setFormsAdd.addMedicamento) {
                        const element = setFormsAdd.addMedicamento[key];
                        let [label, input] = createInput(
                            element.For,
                            element.Text,
                            element.Type,
                            element.Id,
                            element.Name,
                            element.Placeholder
                        );
                        formulario.appendChild(label);
                        formulario.appendChild(input);
                        
                    }
                    button = document.createElement("button");
                    button.setAttribute("id", "post Medicamento");
                    button.setAttribute("type", "submit");
                    button.innerText = "submit";
                    formulario.appendChild(button);
                    break;
                case "addAnimal":
                    formulario = document.getElementById("formAdd");
                    for (const key in setFormsAdd.addAnimal) {
                        const element = setFormsAdd.addAnimal[key];
                        let [label, input] = createInput(
                            element.For,
                            element.Text,
                            element.Type,
                            element.Id,
                            element.Name,
                            element.Placeholder
                        );
                        formulario.appendChild(label);
                        formulario.appendChild(input);
                    }
                    button = document.createElement("button");
                    button.setAttribute("id", "post Animal");
                    button.setAttribute("type", "submit");
                    button.innerText = "submit";
                    formulario.appendChild(button);
                    break;
                case "addVeterinario":
                    formulario = document.getElementById("formAdd");
                    for (const key in setFormsAdd.addVeterinario) {
                        const element = setFormsAdd.addVeterinario[key];
                        let [label, input] = createInput(
                            element.For,
                            element.Text,
                            element.Type,
                            element.Id,
                            element.Name,
                            element.Placeholder
                        );
                        formulario.appendChild(label);
                        formulario.appendChild(input);
                    }
                    button = document.createElement("button");
                    button.setAttribute("id", "post Veterinario");
                    button.setAttribute("type", "submit");
                    button.innerText = "submit";
                    formulario.appendChild(button);
                    break;
                case "addAgendamento":
                    formulario = document.getElementById("formAdd");
                    for (const key in setFormsAdd.addAgendamento) {
                        const element = setFormsAdd.addAgendamento[key];
                        let [label, input] = createInput(
                            element.For,
                            element.Text,
                            element.Type,
                            element.Id,
                            element.Name,
                            element.Placeholder
                        );
                        formulario.appendChild(label);
                        formulario.appendChild(input);
                    }
                    button = document.createElement("button");
                    button.setAttribute("id", "post Agendamento");
                    button.setAttribute("type", "submit");
                    button.innerText = "submit";
                    formulario.appendChild(button);
                    break;
            }
            formulario.onsubmit = function(e){
                e.preventDefault();
                buttonId = e.submitter.id;
                console.log("submit", buttonId);
                postOperation(buttonId.split(" ")[1], Object.fromEntries(new FormData(formulario)));
                
            }


            
        }
    });
});

postOperation = (tipo, dados) => {
    switch(tipo) {
        case "Medicamento":
            console.log("Postando medicamento:", dados);
            url = `http://localhost:8080/estoque/${dados.animal.toUpperCase()}/adicionar?nome=${dados.medicamento}&quantidade=${parseInt(dados.qtd)}`;
            fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
            })
            .then(Response => {
                if (Response.ok) {
                    console.log("Medicamento adicionado com sucesso!");
                } else {
                    console.error("Erro ao adicionar medicamento:", Response.statusText);
                }
            })
            .catch(error => {
                console.error("Erro na requisição:", error);
            })
            break;
        case "Animal":
            console.log("Postando animal:", dados);
            fetch(`http://localhost:8080/animais/${dados.tipo.toUpperCase()}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    nome: dados.nome,
                    idade: parseInt(dados.idade),
                    raca: dados.raca
                })
            })
            .then(Response => {
                if (Response.ok) {
                    console.log("animal adicionado com sucesso!");
                } else {
                    console.error("Erro ao adicionar animal:", Response.statusText);
                }
            })
            .catch(error => {
                console.error("Erro na requisição:", error);
            })
            break;
        case "Veterinario":
            console.log("Postando veterinario:", dados);
            fetch(`http://localhost:8080/veterinarios`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(dados)
                
            })
            .then(Response => {
                if (Response.ok) {
                    console.log("veterinario adicionado com sucesso!");
                } else {
                    console.error("Erro ao adicionar veterinario:", Response.statusText);
                }
            })
            .catch(error => {
                console.error("Erro na requisição:", error);
            })
            break;
        case "Agendamento":
            console.log("Postando agendamento:", dados);
            fetch('http://localhost:8080/agendamentos', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    id: 0,
                    data: convertDate(dados.data),
                    animalId: parseInt(dados.animal),
                    veterinarioId: parseInt(dados.veterinario)
                })
                
            })
            .then(Response => {
                if (Response.ok) {
                    console.log("agendamento adicionado com sucesso!");
                } else {
                    console.error("Erro ao adicionar agendamento:", Response.statusText);
                }
            })
            .catch(error => {
                console.error("Erro na requisição:", error);
            })
            break;
    }
}


createInput = (lFor, lText, iType, iId, iName, iPlaceholder) => {
    let label = document.createElement("label");
    label.setAttribute("for", lFor);
    label.innerText = lText;
    let input = document.createElement("input");
    input.setAttribute("type", iType);
    input.setAttribute("id", iId);
    input.setAttribute("name", iName);
    input.setAttribute("placeholder", iPlaceholder);
    return [label, input];
}



convertDate = (dataISO) => {
    const [ano, mes, dia] = dataISO.split("-");
    return `${ano}-${mes}-${dia}`;
}