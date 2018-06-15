package h20kotlin.java.person

class KPerson(val name: String?, val town: KTown?)

class KTown(val name: String?, val postalCode: String?, val townLevel: KTownLevel?)

class KTownLevel(val level: Int?)
