/* 
 * Copyright (c) 2007, Fraunhofer-Gesellschaft
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 * (1) Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the disclaimer at the end.
 *     Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in
 *     the documentation and/or other materials provided with the
 *     distribution.
 * 
 * (2) Neither the name of Fraunhofer nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 * 
 * DISCLAIMER
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *  
 */
package org.ogf.graap.wsag.server.engine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.ogf.graap.wsag.server.actions.impl.AgreementFactoryAction;
import org.ogf.schemas.graap.wsAgreement.AgreementTemplateType;

/**
 * The template registry is the central store of factory actions. An {@link AgreementFactoryAction} implements
 * the required functionality to create templates, negotiate offer, and create agreement. Each factory action
 * is identified by the agreement template, which is generated by the factory action.
 * 
 * @see org.ogf.graap.wsag.server.actions.impl.AgreementFactoryAction
 * @see org.ogf.graap.wsag.server.actions.AbstractGetTemplateAction
 * @see org.ogf.graap.wsag.server.actions.AbstractNegotiationAction
 * @see org.ogf.graap.wsag.server.actions.AbstractCreateAgreementAction
 * 
 * @author Oliver Waeldrich
 * 
 */
public class TemplateRegistry
{

    //
    // Map for quick lookup of the factory action for a template
    //
    private Map<TemplateIdentifier, AgreementFactoryAction> registryMap =
        new HashMap<TemplateIdentifier, AgreementFactoryAction>();

    //
    // When getting all templates from the registry, we want to preserve
    // the order of the templates, as they where added. The registry list
    // does this for us.
    //
    private List<AgreementFactoryAction> registryList = new Vector<AgreementFactoryAction>();

    /**
     * Adds a new factory action to the registry
     * 
     * @param action
     *            the action to add
     */
    public void add( AgreementFactoryAction action )
    {
        synchronized ( registryMap )
        {
            registryMap.put( new TemplateIdentifier( action.getTemplate() ), action );
            registryList.add( action );
        }
    }

    /**
     * Finds a template with a given name.
     * 
     * @param name
     *            the name of the requested template
     * 
     * @return the agreement template, or <code>null</code> if not found
     */
    public AgreementTemplateType findTemplate( String name )
    {
        return findTemplate( name, "" );
    }

    /**
     * Finds a template with a given name and version.
     * 
     * @param name
     *            the name of the requested template
     * 
     * @param version
     *            the version of the requested template
     * 
     * @return the agreement template, or <code>null</code> if not found
     */
    public AgreementTemplateType findTemplate( String name, String version )
    {
        AgreementFactoryAction action = registryMap.get( ( new TemplateIdentifier( name, version ) ) );
        return ( action == null ) ? null : action.getTemplate();
    }

    /**
     * Finds the factory action for a template with a given name.
     * 
     * @param name
     *            the template name of the requested action
     * 
     * @return the factory, or <code>null</code> if not found
     */
    public AgreementFactoryAction findAction( String name )
    {
        return findAction( name, "" );
    }

    /**
     * Finds the factory action for a template with a given name.
     * 
     * @param name
     *            the template name of the requested action
     * 
     * @param version
     *            the template version of the requested action
     * 
     * @return the factory, or <code>null</code> if a factory with the given name was not found.
     */
    public AgreementFactoryAction findAction( String name, String version )
    {
        AgreementFactoryAction action = registryMap.get( new TemplateIdentifier( name, version ) );
        return ( action == null ) ? null : action;
    }

    /**
     * Returns the template entries of this registry in the same order in which they were added.
     * 
     * @return the registered templates
     */
    public AgreementTemplateType[] getAllTemplates()
    {
        synchronized ( registryMap )
        {
            List<AgreementTemplateType> result = new Vector<AgreementTemplateType>();

            Iterator<AgreementFactoryAction> values = registryList.iterator();
            while ( values.hasNext() )
            {
                AgreementFactoryAction action = values.next();
                result.add( action.getTemplate() );
            }

            return (AgreementTemplateType[]) result.toArray( new AgreementTemplateType[result.size()] );
        }
    }

    /**
     * Returns a set of templates that support SLA negotiation. Negotiation is supported for each action that
     * implements a negotiation strategy, e.g. that registers different action than
     * {@link org.ogf.graap.wsag.server.actions.impl.NegotiationUnsupportedAction}.
     * 
     * @return the registered negotiable templates
     * 
     * @see AgreementFactoryAction#isNegotiationSupported()
     */
    public AgreementTemplateType[] getNegotiableTemplates()
    {
        synchronized ( registryMap )
        {
            List<AgreementTemplateType> result = new Vector<AgreementTemplateType>();

            Iterator<AgreementFactoryAction> values = registryList.iterator();
            while ( values.hasNext() )
            {
                AgreementFactoryAction action = values.next();
                if ( action.isNegotiationSupported() )
                {
                    result.add( action.getTemplate() );
                }
            }

            return (AgreementTemplateType[]) result.toArray( new AgreementTemplateType[result.size()] );
        }
    }
}
