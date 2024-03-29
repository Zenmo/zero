
export type ProjectConfiguration = {
    name: ProjectName,
    email: string,
    logo?: string,
    authorizationPdf?: string,
}

export type ProjectName = 'Hessenpoort' | 'De Wieken'

export const HESSENPOORT: ProjectConfiguration = {
    name: 'Hessenpoort',
    email: 'info@ondernemersvereniginghessenpoort.nl',
    logo: '/logo-hessenpoort.png',
    authorizationPdf: '/spectral-machtiging.pdf',
}

export const DE_WIEKEN: ProjectConfiguration = {
    name: 'De Wieken',
    email: 'info@zenmo.com',
    authorizationPdf: '/machtiging-datadeling-de-wieken.pdf'
}
