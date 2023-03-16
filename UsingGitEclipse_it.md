# Uso dei progetti Git in Eclipse


Le operazioni da eseguire per utilizzare i progetti presenti sui repository Git in Eclipse, sono le seguenti:

- [Clone di un progetto](#clone-di-un-progetto)
- [Commit e Push del progetto](#commit-del-progetto)
- [Update del progetto](#update-del-progetto)


Clone di un progetto
-------------------

- Per poter effettuare l'operazione occorre ottenere l'URL del repository reperibile sulla pagina di GitLab del repository copiando l'URL corrispondente a *Clone with HTTPS* del progetto:
 
    ![Repository Details](CloneInfo.png)

- Quindi, in Eclipse, dal menù _File_ selezionare _Import_, compare la finestra:  

    ![Import wizard](ImportWizard.png)
    
    - Selezionare _Git_ e poi _Projects from Git_
    - Cliccare su `Next >`

- Compare la selezione del repository:

    ![Select repo](SelectRepository.png)

    - Scegliere *Clone URI*
    - Cliccare su `Next >`
    
- Compare la finestra in cui inserire i dati del repository di origine:

    ![Repository Details](GitSource.png)

    - Inserire l'URL copiato dalla pagina GitLab del repository
    - Inserire nome utente e password[^account].
    - Cliccare su `Next >`
    
- Compare la finestra per la selezione del branch (potrebbero essere richiesti nuovamente nome utente e password)

    ![Repository Details](BranchSelection.png)

    - Mantenere la selezione (*Main*)
    - Cliccare su `Next >`

- Compare la finestra per selezionare la destinazione

    ![Select resource](Destination.png)
    
    - è possibile lasciare la cartella suggerita oppure selezionarne un'altra
    - Cliccare su `Next >`
    
- Compare la finestra per la modalità di import

    ![Select resource](CloneProject.png)
    
    - selezionare "*Import existing Eclipse projects*"
    - Cliccare su `Next >`
    
    
- Viene mostrato il progetto presente nel repository, cliccare su `Finish`


Commit del Progetto
-------------------

Per effettuare il commit del progetto nel repository (ovvero salvare una copia dello stato corrente del progetto):

- Fare un click destro sul progetto (non una sua parte), poi selezionare _Team_ e poi _Commit..._;
    Compare il tab *Git Staging*

  ![Commit](GitStaging.png)
    
    Nella sezione "*Unstashed Changes*" sono elencate le modifiche:
    
    - file cambiati: ![](ChangedFile.png) 
    - file aggiunti nel progetto  ![](NewFile.png)

    È possibile aggiungere tutte le modifiche (pulsante ++) o solo alcune. Le modifiche aggiunte compaiono nella sezione "*Stashed Changes*".
    
    Occorre:
    
    - scrivere un commento (es. "Requisito R1")
    - cliccare su `Commit and Push`

- Compare la finestra con la conferma dell'operazione.
  Il progetto è ora salvato su repository.

Attenzione: se si effettua solamente il "*Commit*" senza "*Push*" la modifica viene memorizzata solo nel repository locale e non inviata al repository centrale.

Update del Progetto
-------------------

Se il progetto sul repository è stato aggiornato rispetto a quello presente in locale è necessario aggiornare la copia locale.

Per aggiornare la copia locale:

- Fare un click destro sul progetto (non una sua parte), poi selezionare _Team_ e poi _Pull_;
- Compare la finestra con l'esito dell'operazione di merge tra quanto presente in locale ed i commit presenti sul repository.

È buona norma effettuare un Pull dal repository prima di iniziare a lavorare in modo da essere allineati con i contenuti del repository.


[^account]: Le informazioni per attivare l'account sono fornite in un'email da `gitlab@git-oop.polito.it`, se non l'avete ricevuta verificate nello spam. In ogni caso è possibile recuperare la propria password indicando la propria email del tipo `s987654@studenti.polito.it` dalla pagina <https://git-oop.polito.it/> 


----

Version 1.0 - 2023-03-03
