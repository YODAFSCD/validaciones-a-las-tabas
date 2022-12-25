package com.example.client.service

import com.example.client.model.Invoice
import com.example.client.repository.InvoiceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class InvoiceService {
    @Autowired
    lateinit var invoiceRepository: InvoiceRepository
    @Autowired
    lateinit var clientRepository: InvoiceRepository


    fun list ():List<Invoice>{
        return invoiceRepository.findAll()
    }

    fun listTotalMoreThan(total:Double):List<Invoice>?{
        return invoiceRepository.findTotalMoreThan(total)
    }

    fun updateFromDetail(total:Double):List<Invoice>?{
        return invoiceRepository.findTotalMoreThan(total)
    }

    fun save (invoice: Invoice):Invoice{
        try{
            clientRepository.findById(invoice.clientId)
                ?:throw Exception("El id ${invoice.clientId} de cliente no existe")
            return invoiceRepository.save(invoice)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }




    }

    fun update(invoice: Invoice):Invoice{
        try {
            invoiceRepository.findById(invoice.id)
                ?: throw Exception("El id ${invoice.id} en factura no existe")
            return invoiceRepository.save(invoice)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateTotal(invoice: Invoice):Invoice{
        try{
            val response = invoiceRepository.findById(invoice.id)
                ?:throw Exception("El ${invoice.id} en factura no existe")

            response.apply{
                total = invoice.total
            }
            return invoiceRepository.save(response)
        }
        catch (ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)

        }
    }
}
