Volkshochschule – MVC-Paketstruktur

Pakete:
- main: JavaFX-Startklasse
- business: Volkshochschulkurs und VolkshochschulkursModel
- gui: VolkshochschuleView und VolkshochschuleControl
- ownUtil: MeldungsfensterAnzeiger

CSV-Import: Volkshochschulkurs.csv im Arbeitsverzeichnis.
CSV-Export: VolkshochschulkurseAusgabe.csv (Datensätze werden angehängt).
txt-Import bleibt wie in der Vorlage nicht implementiert.

Für JavaFX muss JavaFX im Projekt eingebunden und als VM-Argument konfiguriert sein.
