package org.jrimum.bopepo.pdf;

import static org.jrimum.utilix.Objects.checkNotNull;
import static org.jrimum.utilix.Objects.isNotNull;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.jrimum.utilix.Exceptions;

import com.lowagie.text.pdf.PdfDate;

/**
 * Pricipais informações de um documento PDF: <tt>Título, Autor, Assunto,
 * Palavras-chave, Aplicativo criador, Data de criação e Data de modificação</tt>
 * .
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * 
 */
public class PdfDocInfo {

	/*
	 * Mesmas chaves usadas pelo itext.
	 */
	
	/**
	 * Key = Título do documento. 
	 */
	private static final String DOC_TITLE = "Title";
	/**
	 * Key = Autor do documento. 
	 */
	private static final String DOC_AUTHOR = "Author";
	/**
	 * Key = Assunto do documento. 
	 */
	private static final String DOC_SUBJECT = "Subject";
	/**
	 * Key = Palavras-chave do documento. 
	 */
	private static final String DOC_KEYWORDS = "Keywords";
	/**
	 * Key = Ferramenta/Software usada para do documento. 
	 */
	private static final String DOC_CREATOR = "Creator";
	/**
	 * Key = Data de criação do documento. 
	 */
	private static final String DOC_CREATION_DATE = "CreationDate";
	/**
	 * Key = Data de modificação do documento. 
	 */
	private static final String DOC_MODIFACTION_DATE = "ModDate";
	
	/**
	 * Key = Ferramenta/Software que de fato produziu o documento. 
	 */
	private static final String DOC_PRODUCER = "Producer";

	/**
	 * Map com informações sobre o documento: Title, Author, Subject, etc.
	 */
	private final Map<String, String> docInfo;

	/**
	 * Modo de criação não utilizado e não permitido. 
	 */
	private PdfDocInfo() {
		Exceptions.throwIllegalStateException("Estado não permitido!");
		docInfo = null;
	}

	/**
	 * Apenas para uso interno.
	 * 
	 * @param info
	 */
	private PdfDocInfo(Map<String, String> info) {

		checkNotNull(info);

		this.docInfo = info;
	}

	/**
	 * Cria uma nova instância sem informações.
	 * 
	 * @return referência prota para uso
	 */
	public static PdfDocInfo create() {

		return new PdfDocInfo(new HashMap<String, String>(8));
	}

	/**
	 * Cria uma nova instância com as informações fornecidas.
	 * 
	 * @param info Informações sobre um documento
	 * 
	 * @return referência prota para uso
	 */
	public static PdfDocInfo create(Map<String, String> info) {

		checkNotNull(info, "INFO INVÁLIDA!");

		return new PdfDocInfo(info);
	}

	/**
	 * Define o Título do documento.
	 * 
	 * @param title
	 * 
	 * @return Esta instância após a operação
	 */
	public PdfDocInfo title(String title) {

		if (isNotNull(title)) {
			docInfo.put(DOC_TITLE, title);
		}

		return this;
	}

	/**
	 * Define o Autor do documento.
	 * 
	 * @param author
	 * 
	 * @return Esta instância após a operação
	 */
	public PdfDocInfo author(String author) {

		if (isNotNull(author)) {
			docInfo.put(DOC_AUTHOR, author);
		}

		return this;
	}

	/**
	 * Define o Assunto do documento.
	 * 
	 * @param subject
	 * 
	 * @return Esta instância após a operação
	 */
	public PdfDocInfo subject(String subject) {

		if (isNotNull(subject)) {
			docInfo.put(DOC_SUBJECT, subject);
		}

		return this;
	}

	/**
	 * Define as Palavras-chave do documento.
	 * 
	 * @param keywords
	 * 
	 * @return Esta instância após a operação
	 */
	public PdfDocInfo keywords(String keywords) {

		if (isNotNull(keywords)) {
			docInfo.put(DOC_KEYWORDS, keywords);
		}

		return this;
	}

	/**
	 * Define o Software/Ferramenta de criação do documento.
	 * 
	 * @param creator
	 * 
	 * @return Esta instância após a operação
	 */
	public PdfDocInfo creator(String creator) {

		if (isNotNull(creator)) {
			docInfo.put(DOC_CREATOR, creator);
		}

		return this;
	}

	public String title() {

		return docInfo.get(DOC_TITLE);
	}

	public String author() {

		return docInfo.get(DOC_AUTHOR);
	}

	public String subject() {

		return docInfo.get(DOC_SUBJECT);
	}

	public String keywords() {

		return docInfo.get(DOC_KEYWORDS);
	}

	public String creator() {

		return docInfo.get(DOC_CREATOR);
	}

	public String creationRaw() {

		return docInfo.get(DOC_CREATION_DATE);
	}

	public Calendar creation() {
		
		return PdfDate.decode(docInfo.get(DOC_CREATION_DATE));
	}
	
	public String modificationRaw() {

		return docInfo.get(DOC_MODIFACTION_DATE);
	}
	
	public Calendar modification() {
		
		return PdfDate.decode(docInfo.get(DOC_MODIFACTION_DATE));
	}
	
	/**
	 * Retorna a descrição do produtor do documento.
	 *  
	 * <p>
	 * You can’t change this without breaking the software license that allows
	 * you to use iText for free.
	 * </p>
	 * 
	 * @return Descrição do produtor
	 */
	public String producer() {
		
		return docInfo.get(DOC_PRODUCER);
	}

	/**
	 * Transforma as informações do documento em um novo Map a cada chamada.
	 * 
	 * @return Map de informações
	 */
	public Map<String,String> toMap(){
		
		return new HashMap<String,String>(docInfo);
	}
	
	/**
	 * Geração a partir do {@code hashCode()} do {@link #docInfo}.
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((docInfo == null) ? 0 : docInfo.hashCode());
		return result;
	}

	/**
	 * Comparação com base no {@link #docInfo}. 
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdfDocInfo other = (PdfDocInfo) obj;
		if (docInfo == null) {
			if (other.docInfo != null)
				return false;
		} else if (!docInfo.equals(other.docInfo))
			return false;
		return true;
	}

	/**
	 * Informação contida em {@link #docInfo}. 
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PdfDocInfo [docInfo=" + docInfo + "]";
	}
	
}
