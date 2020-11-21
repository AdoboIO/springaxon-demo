# springaxon-demo
Demo of SpringBoot and Axon integration


Setting the context

Deal Lifecycle defined as follows:

* Origination - the state where the client requests to create a deal.
* Issuance - the state where the deal is created and issued to the client. The deal is now in active state.
* Amendment - the state where the deal has undergone a revision.
* Utilization -  the state where the deal is used as a finance instrument.
* Payment - the state where the deal is settled (see utilization).
* Completion - the end of the deal lifecyle.