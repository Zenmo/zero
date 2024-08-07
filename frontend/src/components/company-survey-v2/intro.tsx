import {css} from '@emotion/react'
import {FunctionComponent} from 'react'
import {ProjectConfiguration} from './project'

export const Intro: FunctionComponent<{project: ProjectConfiguration}> = ({project}) => {
    return (
        <>
            <div css={css`
                display: flex;
                height: 3rem;
                justify-content: space-between;
                flex-direction: row-reverse;
            `}>
                <img src="/logo-zenmo.png" alt="logo-zenmo" />
                {project.logo && <img src={project.logo} alt="logo-project" />}
            </div>
            <br />
            <br />
            <h1>Dataformulier energie en mobiliteit {project.name}</h1>
            <p>
                Met dit formulier halen we de energie- en mobiliteitsdynamieken op van {project.name}, zowel in de
                huidige als de toekomstige situatie. Samen met gegevens van de netbeheerder worden deze dynamieken
                nagespeeld in de digital twin. Het doel is om daarmee gezamenlijk te verkennen welke congestieproblemen
                zich voordoen, welke oplossingen er mogelijk zijn en welke uitbreidingsplannen de komende
                jaren wel of niet doorgezet kunnen worden.
            </p>
            <p>
                Alle ingevulde gegevens worden vertrouwelijk behandeld en blijven eigendom van de bedrijven zelf.
                Parkmanagement {project.name} beheert de gegevens tijdens het project en Zenmo Simulations laadt ze
                in de digital twin.
            </p>
            <p>
                Het invullen zal circa 10 tot 20 minuten duren. Echter, het is mogelijk dat het één en ander 
                opgezocht moet worden. Bijvoorbeeld het gecontracteerd (teruglever)vermogen, inloggegevens van uw
                meetbedrijf of het aantal vrachtwagens. Ook bij de paar bedrijven met meerdere netaansluitingen zal 
                het wat meer tijd kosten. 
            </p>
            <p>
                Als u aanvullende energiedynamieken wilt benoemen, dan kunt u deze via de mail ter attentie brengen
                van <a href={`mailto:${project.email}`}>{project.email}</a>. We kunnen uw situatie dan nog realistischer meenemen
                in de digital twin.
            </p>
        </>
    )
}