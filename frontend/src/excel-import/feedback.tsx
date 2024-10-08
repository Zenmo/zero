import {FunctionComponent, useState} from "react"
import {SurveyWithErrors} from "zero-zummon"
import {Message} from "primereact/message"
import {Button} from "primereact/button"
import {mapOrElse} from "../services/util"

import {useToggle} from "../hooks/use-toggle"

export const Feedback: FunctionComponent<{
    surveyWithErrors: SurveyWithErrors
    navigateNext: () => void
}> = ({surveyWithErrors, navigateNext}) => {
    const [dataVisible, toggleDataVisible] = useToggle()

    return (
        <>
            <div style={{
                display: "flex",
                flexDirection: "column",
                gap: "1rem",
                paddingBottom: "1rem",
            }}>
                {mapOrElse(
                    surveyWithErrors.errors.asJsReadonlyArrayView(),
                    (error, i) => <Message severity="warn" text={error} key={i} />,
                    () => <Message severity="info" text="Alle checks OK" key="ok" />,
                )}
            </div>
            <div style={{
                display: "flex",
                gap: "1rem",
            }}>
                <Button label={dataVisible ? "{} Data verbergen" : "{} Data bekijken"} onClick={toggleDataVisible}/>
                <Button label="Panden selecteren" icon="pi pi-arrow-right" onClick={navigateNext} />
            </div>
            {dataVisible && <pre>{surveyWithErrors.survey.toPrettyJson()}</pre>}
        </>
    )
}

