# Eksamen Objektorientert programmering Vår 2025

### Eksamensbesvarelse i objektorientert programmering (pgr112) i 2025 

**Vurdering: Godkjent**

**Beskrivelse:**
Besvarelsen går ut på å hente data fra en txt fil og sende de til en database gjennom Java. 
Videre kan brukere kjøre følgende funksjoner:
1. Se informasjon om alle kjøretøy
2. Se hvor mye drivstoff det er i alle fossile biler
3. Se informasjon om alle kjørbare kjøretøy
4. Se alle kjøretøy filtrert etter bilopphuggeri
5. Avslutt program

### Begrunnelse fra sensor:
Det er mye positivt i besvarelsen, og kandidaten er godt på vei til å beherske læringsmålene i
emnet. Kandidaten har vist god forståelse for objektorientert programmering gjennom
fornuftig bruk av arv og polymorfi, samt implementasjon av abstrakte klasse.
Unntakshåndtering er benyttet på en tilfredsstillende måte, og innkapsling er implementert. I
tillegg er kravene til både JDBC og filhåndtering oppfylt. Kandidaten har også klart å ta i
bruk objektklassene i løsningen på en hensiktsmessig måte.
Kandidaten har derfor oppnådd kravene til læringsutbytte. Besvarelsen ble derfor vurdert til
bestått.


### Eksamensoppgaven: 
Det nyopprettede selskapet Scrapyard med filialer i tre norske byer tar imot biler og motorsykler. De
ønsker å strukturere informasjonen de har om de ulike kjøretøyene. De har laget en fil med
informasjon (vehicles.txt), og denne informasjonen skal overføres til en database.

Du skal lage et program som leser fra filen vehicles.txt og legger dataene inn i en database. Et forslag
til databasestruktur finner du i filen scrapyard.sql. Du kan velge å gjøre justeringer i scrapyard.sql,
men det skal ikke være nødvendig. Det er heller ikke anbefalt å gjøre endringer i databasen da det vil
stjele tid. 

**Del 1:**
Når du er ferdig med del 1 bør du ha:
- En velfungerende database som har informasjon om skraphandlerstedene (scrapyards) og
kjøretøy (vehicles). Tabellene i databasen er fylt med data basert på filen vehicles.txt.
- En eller flere klasser som kan kommunisere med databasen.
- En eller flere klasser som kan holde i data fra databasen. Det er forventet at arv benyttes for
klasser som omfatter ulike typer kjøretøy ettersom de har mange felles egenskaper. Det er
også forventet at disse klassene blir benyttet i kommunikasjon med databasen.

**Del 2:**
Du skal lage et lite program som tilbyr brukeren en meny med noen menyvalg som omhandler
skraphandlerstedene og kjøretøyene som nå er plassert i databasen (etter at del 1 er gjennomført).
Du kan selv velge om du vil ha to main-metoder (en for del 1 og en for del 2), eller om du vil
kommentere ut koden for del 1 når du utvikler del 2. Eller du kan velge å ha del 1 og del 2 i samme
program.
Programmet skal tilby følgende funksjonalitet:
- Se informasjon om alle kjøretøy.
- Se informasjon om hvor mye drivstoff som befinner seg i fossilbilene totalt.
- Se informasjon om alle kjøretøy som er kjørbare.
- En valgfri funksjonalitet som du selv velger. Valgt funksjonalitet må medføre kommunikasjon
med databasen.
- Avslutte programmet.

[Les resten av eksamensoppgaven her](https://github.com/umaira04/pgr112_spring2025_exam/blob/main/eksamen2025/src/files/Eksamen%20OOP%20jun%202025.pdf)
